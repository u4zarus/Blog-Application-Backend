package org.example.entities;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class DAO {
    EntityManagerFactory emf;
    EntityManager em;
    EntityTransaction et;

    public DAO() {
        emf = Persistence.createEntityManagerFactory("ApplicationPU");
        em = emf.createEntityManager();
        et = em.getTransaction();
    }

    public void beginTransaction() {
        et.begin();
    }

    public void commitTransaction() {
        et.commit();
    }

    public BUser getUser(int userId) {
        return em.find(BUser.class, userId);
    }

    public void createUser(int loginId, String email, String password, String phoneNumber, String firstName, String lastName) {
        beginTransaction();
        LoginInfo loginInfo = new LoginInfo(loginId, email, password);
        BUser bUser = new BUser(loginId, phoneNumber, firstName, lastName);

        // check if user with this loginId or email or phone number already exists
        if (em.find(BUser.class, loginId) != null) {
            System.out.println("User with this loginId already exists");
            return;
        }
        // Check if a user with the given email already exists
        TypedQuery<LoginInfo> emailQuery = em.createQuery("SELECT u FROM LoginInfo u WHERE u.e_mail = :email", LoginInfo.class);
        emailQuery.setParameter("email", email);
        List<LoginInfo> usersWithEmail = emailQuery.getResultList();

        if (!usersWithEmail.isEmpty()) {
            System.out.println("User with this email already exists");
            return;
        }

        // Check if a user with the given phone number already exists
        TypedQuery<BUser> phoneQuery = em.createQuery("SELECT u FROM BUser u WHERE u.phone_number = :phoneNumber", BUser.class);
        phoneQuery.setParameter("phoneNumber", phoneNumber);
        List<BUser> usersWithPhoneNumber = phoneQuery.getResultList();

        if (!usersWithPhoneNumber.isEmpty()) {
            System.out.println("User with this phone number already exists");
            return;
        }

        bUser.setLoginInfo(loginInfo);
        em.persist(bUser);
        System.out.println("Persisted " + bUser.toString());
        commitTransaction();
    }

    public void createPost(int postId, int blogId, int authorId, String postTitle, String postContent) {
        beginTransaction();
        Post existingPost = em.find(Post.class, postId);
        if (existingPost != null) {
            System.out.println("Post with ID " + postId + " already exists");
            return;
        }
        LocalTime currentTime = LocalTime.now();
        LocalDate currentDate = LocalDate.now();
        Date sqlDate = Date.valueOf(currentDate);
        Time sqlTime = Time.valueOf(currentTime);
        Blog blog = em.find(Blog.class, blogId);
        Administrator author = em.find(Administrator.class, authorId);
        Post post = new Post(postId, blog, author, postTitle, postContent, sqlTime, sqlDate);
        em.persist(post);
        System.out.println("Persisted " + post.toString());
        commitTransaction();
    }

    public void followBlog(int userId, int blogId) {
        beginTransaction();
        BUser user = em.find(BUser.class, userId);
        Blog blog = em.find(Blog.class, blogId);
        if (user.getBlogs() == null) {
            user.setBlogs(new ArrayList<>());
        }
        if (user.getBlogs().contains(blog)) {
            System.out.println("User " + user.getUser_id() + " is already following blog " + blog.getBlog_id());
            return;
        }
        user.getBlogs().add(blog);
        blog.getUsers().add(user);
        em.persist(user);
        em.persist(blog);
        System.out.println("User " + user.getUser_id() + " is now following blog " + blog.getBlog_id());
        commitTransaction();
    }

    public void unfollowBlog(int userId, int blogId) {
        beginTransaction();
        BUser user = em.find(BUser.class, userId);
        Blog blog = em.find(Blog.class, blogId);
        if (user.getBlogs() == null) {
            user.setBlogs(new ArrayList<>());
        }
        if (!user.getBlogs().contains(blog)) {
            System.out.println("User " + user.getUser_id() + " is not following blog " + blog.getBlog_id());
            return;
        }
        user.getBlogs().remove(blog);
        blog.getUsers().remove(user);
        em.persist(user);
        em.persist(blog);
        System.out.println("User " + user.getUser_id() + " is no longer following blog " + blog.getBlog_id());
        commitTransaction();
    }

    public void createBlog(int blogId, String blogName, int adminId, int userId) {
        beginTransaction();
        BUser user = em.find(BUser.class, userId);

        Administrator admin = em.find(Administrator.class, adminId);
        if (admin != null && admin.getUser().equals(user)) {
            System.out.println("User is already an administrator");
        } else {
            admin = new Administrator(adminId, user);
            em.persist(admin);
        }

        Blog existingBlog = em.find(Blog.class, blogId);
        if (existingBlog != null) {
            System.out.println("Blog with this id already exists");
            return;
        }

        TypedQuery<Blog> nameQuery = em.createQuery("SELECT u FROM Blog u WHERE u.blog_name = :blogName", Blog.class);
        nameQuery.setParameter("blogName", blogName);
        List<Blog> blogsWithName = nameQuery.getResultList();
        if (!blogsWithName.isEmpty()) {
            System.out.println("Blog with this name already exists");
            return;
        }

        Blog blog = new Blog(blogId, blogName, null);

        OwnerBlog ownerBlog = new OwnerBlog();
        ownerBlog.setOwner(admin);
        ownerBlog.setBlog(blog);

        AdminBlog adminBlog = new AdminBlog();
        adminBlog.setAdministrator(admin);
        adminBlog.setBlog(blog);

        em.persist(blog);
        em.persist(ownerBlog);
        em.persist(adminBlog);
        System.out.println("Persisted " + blog.toString());
        commitTransaction();
    }

}
