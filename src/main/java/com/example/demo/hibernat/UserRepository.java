package com.example.demo.hibernat;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository extends PagingAndSortingRepository<User, Long>{
    User findByUserId(String userId);

}
