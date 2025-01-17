package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import dto.Orderbbs;

public class OrderbbsDAO {
    Statement stmt;
    PreparedStatement pstmt;
    ResultSet rs;
    
    DAO d = new DAO();
    
    //총 게시물 수
    public int getAllcount(String field,String search) {
        d.getCon();
        int count=0;
        try {
            String sql = "select count(*) from orderbbs";
            
            if(search != null && !search.equals("")) {
                sql = "select count(*) from orderbbs where "+field+" like '%"+search+"%'";
            }
            pstmt=d.con.prepareStatement(sql);
            rs=pstmt.executeQuery();
            
            if(rs.next()) {
                count = rs.getInt(1);
            }
            rs.close();
            pstmt.close();
            d.con.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }
    //게시물목록
    public ArrayList<Orderbbs> getAllNotice(int startRow,int endRow,String field, String search) {
        d.getCon();
        
        ArrayList<Orderbbs> v = new ArrayList<>();
        
        try {
            String sql = "select * from orderbbs order by signdate desc limit ?,?";
            if(search != null && !search.equals("")) {
                sql = "select * from orderbbs where "+field+" like '%"+search+"%' order by signdate desc limit ?,?";
            }   
            pstmt = d.con.prepareStatement(sql);
            pstmt.setInt(1, startRow);
            pstmt.setInt(2, endRow);
            
            rs = pstmt.executeQuery();
            
            while(rs.next()) {
                Orderbbs n = new Orderbbs();
                
                n.setUid(rs.getInt("uid")); 
                n.setId(rs.getString("id"));
                n.setName(rs.getString("name"));
                n.setSubject(rs.getString("subject"));
                n.setComment(rs.getString("comment"));
                n.setSigndate(rs.getString("signdate"));
                n.setRef(rs.getInt("ref"));
                n.setGongji(rs.getString("gongji"));
                 
                v.add(n);
            }
            rs.close();
            pstmt.close();
            d.con.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return v;
    }
    //게시물 등록  
    public void insertNotice(Orderbbs n) {
        d.getCon();
        
        try {
            String sql = "insert into orderbbs values (null,?,?,?,?,?,?,?)";
            pstmt = d.con.prepareStatement(sql);
            
            pstmt.setString(1, n.getId());
            pstmt.setString(2, n.getName());
            pstmt.setString(3, n.getSubject());
            pstmt.setString(4, n.getComment());
            pstmt.setString(5, n.getSigndate());
            pstmt.setInt(6, n.getRef());
            pstmt.setString(7, n.getGongji());

            pstmt.executeUpdate();
            
            pstmt.close();
            d.con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //게시판 상세보기 페이지 
    public Orderbbs oneNotice(int uid) {
        d.getCon();
        Orderbbs n = new Orderbbs();
        
        try {
            String sql = "select * from orderbbs where uid=?";
            
            pstmt = d.con.prepareStatement(sql);
            
            pstmt.setInt(1, uid);

            rs = pstmt.executeQuery();

            if (rs.next()) {
                n.setUid(rs.getInt("uid")); 
                n.setId(rs.getString("id"));
                n.setName(rs.getString("name"));
                n.setSubject(rs.getString("subject"));
                n.setComment(rs.getString("comment"));
                n.setSigndate(rs.getString("signdate"));
                n.setRef(rs.getInt("ref"));
                n.setGongji(rs.getString("gongji"));
            }

            rs.close();
            pstmt.close();
            d.con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return n;
    }
    //게시물수정
    public void updateNotice(Orderbbs n) {
        d.getCon();
        
        try {
            
            String sql = "update orderbbs set subject=?,comment=? where uid=?";
            
            pstmt=d.con.prepareStatement(sql);
            
            pstmt.setString(1, n.getSubject());
            pstmt.setString(2, n.getComment());
            pstmt.setInt(3, n.getUid());
            
            pstmt.executeUpdate();
            
            pstmt.close();
            d.con.close();
        }catch (Exception e) {
            e.printStackTrace();
         }
    }
    //삭제
    public void oneDelete(int uid) {
        d.getCon();
        
        try {
            String sql = "delete from orderbbs where uid=?";
            
            pstmt=d.con.prepareStatement(sql);
            
            pstmt.setInt(1, uid);
            
            pstmt.executeUpdate();
            
            pstmt.close();
            d.con.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}