package com.twistresources.MaintenanceProject.services;

import com.twistresources.MaintenanceProject.entities.Book;
import com.twistresources.MaintenanceProject.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> findAllBooks(){
        return bookRepository.findAll();
    }

    public Book addBook(Book book){
        return bookRepository.save(book);
    }

    public Book findBook(Long id){
        if(bookRepository.existsById(id))
            return bookRepository.getOne(id);
        throw new NullPointerException("no data found at id " + id);
    }

    public Book updateBook(Long id, Book book){
        if(bookRepository.existsById(id)){
            book.setId(id);
            return bookRepository.save( book );
        }throw new NullPointerException("trying to update a non-existing data at id " + id);
    }

//    public Book updateBook(Book book) {
//        bookRepository.findById(book.getId())
//                .orElseThrow(() -> new NullPointerException("Todo not found with id " + todoResource.getId()));
//
//        book.setDescription(todoResource.getDescription());
//        todo.setCompleted(todoResource.isCompleted());
//
//        todoRepository.save(todo);
//        return book;
//    }

    public Boolean deleteBook(Long id){
        if(bookRepository.existsById(id)){
            bookRepository.deleteById(id);
            return true;
        }throw new NullPointerException("trying to delete a non-existing data at id " + id);
    }

}