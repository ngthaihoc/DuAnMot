package com.mycompany.projectone.dao.impl;

import com.mycompany.projectone.dao.CategoriesDAO;
import com.mycompany.projectone.entity.Categories;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoriesDAOImpl implements CategoriesDAO {

  

   

    String createSQL = "INSERT INTO Categories(CategoryID, CategoryName) VALUES (?, ?)";
    String updateSQL = "UPDATE Categories SET CategoryName = ? WHERE CategoryID = ?";
    String deleteSQL = "DELETE FROM Categories WHERE CategoryID = ?";
    String findAllSQL = "SELECT * FROM Categories";
    String findByIDSQL = "SELECT * FROM Categories WHERE CategoryID = ?";

    @Override
   public Categories create(Categories entity) {
    String sql = "INSERT INTO Categories(CategoryID, CategoryName) VALUES (?, ?)";

    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setInt(1, entity.getCategoryID());
        stmt.setString(2, entity.getCategoryName());
        int result = stmt.executeUpdate();

        return result > 0 ? entity : null;

    } catch (SQLException ex) {
        ex.printStackTrace();
        return null;
    }
}

    @Override
   
public void update(Categories entity) {
    String sql = "UPDATE Categories SET CategoryName = ? WHERE CategoryID = ?";

    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setString(1, entity.getCategoryName());
        stmt.setInt(2, entity.getCategoryID());
        stmt.executeUpdate();
    } catch (SQLException ex) {
        ex.printStackTrace(); // Có thể thay bằng Logger nếu muốn chuyên nghiệp hơn
    }
}

   @Override
public void deleteById(Integer id) {
    String sql = "DELETE FROM Categories WHERE CategoryID = ?";

    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setInt(1, id);
        stmt.executeUpdate();
    } catch (SQLException ex) {
        ex.printStackTrace(); // hoặc dùng Logger nếu cần theo dõi lỗi chuyên nghiệp hơn
    }
}

   @Override
public List<Categories> findAll() {
    List<Categories> list = new ArrayList<>();
    String sql = "SELECT * FROM Categories";

    try (PreparedStatement stmt = conn.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {

        while (rs.next()) {
            Categories cat = new Categories();
            cat.setCategoryID(rs.getInt("CategoryID"));
            cat.setCategoryName(rs.getString("CategoryName"));
            list.add(cat);
        }

    } catch (SQLException ex) {
        ex.printStackTrace(); // có thể thay bằng Logger nếu muốn chuyên nghiệp hơn
    }

    return list;
}
 @Override
public Categories findById(Integer id) {
    String sql = "SELECT * FROM Categories WHERE CategoryID = ?";

    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            Categories cat = new Categories();
            cat.setCategoryID(rs.getInt("CategoryID"));
            cat.setCategoryName(rs.getString("CategoryName"));
            return cat;
        }

    } catch (SQLException ex) {
        ex.printStackTrace(); // hoặc ghi log nếu cần
    }

    return null; // nếu không tìm thấy hoặc có lỗi
}
}