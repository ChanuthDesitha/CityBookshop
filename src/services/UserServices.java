/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import dbconnection.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Asus
 */
public class UserServices {
    Connection con = DatabaseConnection.conn();;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    private static int bookId;
    
    public int getBookId() {
        return bookId;
    }
    
    public void setBookId(int bookId) {
        this.bookId = bookId;
    }
    
    public void addBooks(String title, String author, int price, int qty, String category) {
        try {
            String query = "INSERT INTO books (title, author, price, qty, category) VALUES (?, ?, ?, ?, ?)";
            pst = con.prepareStatement(query);
            pst.setString(1, title);
            pst.setString(2, author);
            pst.setInt(3, price);
            pst.setInt(4, qty);
            pst.setString(5, category);
            pst.execute();

            JOptionPane.showMessageDialog(null, "Book added successfully!!!");
                
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void viewBook(String query, JTable table) {
        con = DatabaseConnection.conn();

        try {
            pst = con.prepareStatement(query);
            rs = pst.executeQuery();
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void updateBook(int x, int bookId, String title, String author , int price, int qty, String category) {
        if(x == 0) {
            try {
                String query = "UPDATE books SET title = ?, author = ?, price = ?, qty = ?, category = ? WHERE book_id = " + bookId;
                pst = con.prepareStatement(query);
                pst.setString(1, title);
                pst.setString(2, author);
                pst.setInt(3, price);
                pst.setInt(4, qty);
                pst.setString(5, category);
                pst.execute();

                JOptionPane.showMessageDialog(null, "Book Updated!");

            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
    
    public void removeBook(int bookId) {
        try {
            String query = "DELETE FROM books WHERE book_id = " + bookId;
            pst = con.prepareStatement(query);
            pst.execute();

            JOptionPane.showMessageDialog(null, "Book Removed!");
        } catch(Exception e) {
            System.out.println(e);
        }
    }
}
