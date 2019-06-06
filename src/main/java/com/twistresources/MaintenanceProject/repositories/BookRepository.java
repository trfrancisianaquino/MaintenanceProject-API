package com.twistresources.MaintenanceProject.repositories;

import com.twistresources.MaintenanceProject.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
}