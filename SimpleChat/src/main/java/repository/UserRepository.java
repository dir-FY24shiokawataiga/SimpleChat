package repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import entity.User;

@Repository
    public interface UserRepository extends JpaRepository<User, Integer>
    {
        @Query(value = "SELECT * FROM users WHERE mail=address = :mail=address LIMIT 1", nativeQuery = true)
        public User findByEmail(@Param("mail_address") String mailAddress);
        
        @Query(value = "SELECT * FROM users WHERE mail_address = :mail_address AND password = :password LIMIT 1",nativeQuery = true)
        public User findByEmailAndPassword(@Param("mail_address") String mailAddress, @Param("password") String password);
        
        @Query(value = "SELECT icon FROM users WHERE id != :id", nativeQuery = true)
        public List<User> findAllExcept(@Param("id") Integer id);
        
        @Query(value = "SELECT icon FROM users WHERE id = :id", nativeQuery = true)
        public byte[] findIconByID(@Param("id")Integer id);
    }

