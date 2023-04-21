package control;

import com.mysql.jdbc.PreparedStatement;
import model.Department;
import model.Instructor;
import model.Student;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Integer.parseInt;

public class StudentCRUD {

    public int getId(String name) {
        String sql = "SELECT ID FROM students WHERE dept = ?";

        Connection conn = null;
        PreparedStatement pstm = null;
        int ID = 0;

        try {
            //criar conexao com o banco
            conn = DB.getConnection();
            //prepared statement pora executar query
            pstm = (PreparedStatement) conn.prepareStatement(sql);
            //preencher os ?
            pstm.setString(1, name);
            //executar query
            ResultSet result = pstm.executeQuery();

            while (result.next()) {

                String result1 = result.getString(1);
                ID = parseInt(result1);

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (pstm != null) {
                    pstm.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return ID;
    }

    public void save(Student student){
        String sql = "INSERT INTO students (name, dept, cred) VALUES (?, ?, ?)";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            //criar conexao com o banco
            conn = DB.getConnection();

            //prepared statement pora executar query
            pstm = (PreparedStatement) conn.prepareStatement(sql);

            //preencher os ?
            pstm.setString(1, student.getName());
            pstm.setInt(2, student.getDept());
            pstm.setFloat(3, student.getCred());

            //executar query
            pstm.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            try {
                if(conn != null){
                    conn.close();
                }
                if(pstm != null){
                    pstm.close();
                }



            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    }

    public void showAll() {
        String sql = "SELECT * FROM students";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            //criar conexao com o banco
            conn = DB.getConnection();

            //prepared statement pora executar query
            pstm = (PreparedStatement) conn.prepareStatement(sql);

            //executar query
            ResultSet result = pstm.executeQuery();

            while (result.next()) {

                int ID = result.getInt(1);
                String name = result.getString(2);
                int dept = result.getInt(3);
                float cred = result.getFloat(4);

                DepartmentCRUD crudDep = new DepartmentCRUD();

                Department dep = crudDep.getById(dept);

                String deptName = dep.getDeptName();

                System.out.println(ID + "\t\t" + name
                        + "\t\t" + deptName + "\t\t" + cred);


            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            try {
                if (conn != null) {
                    conn.close();
                }
                if (pstm != null) {
                    pstm.close();
                }


            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

    }

    public void showById(int ID) {

        String sql = "SELECT * FROM students WHERE ID = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        Student stu = null;

        try {
            //criar conexao com o banco
            conn = DB.getConnection();

            //prepared statement pora executar query
            pstm = (PreparedStatement) conn.prepareStatement(sql);

            pstm.setInt(1, ID);

            //executar query
            ResultSet result = pstm.executeQuery();


            while (result.next()) {

                int IDstu = result.getInt(1);
                String name = result.getString(2);
                int IDdept = result.getInt(3);
                float cred = result.getFloat(4);

                DepartmentCRUD crudDep = new DepartmentCRUD();

                Department dep = crudDep.getById(IDdept);

                String deptName = dep.getDeptName();

                System.out.println(IDstu + "\t\t" + name
                        + "\t\t" + deptName + "\t\t" + cred);

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            try {
                if (conn != null) {
                    conn.close();
                }
                if (pstm != null) {
                    pstm.close();
                }


            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

    }

    public void updateName(int ID, String name) {
        String sql = "UPDATE students SET name = ? WHERE ID = ?";


        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            //criar conexao com o banco
            conn = DB.getConnection();

            //prepared statement pora executar query
            pstm = (PreparedStatement) conn.prepareStatement(sql);

            //preencher os ?
            pstm.setString(1, name);
            pstm.setInt(2, ID);

            //executar query
            pstm.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            try {
                if (conn != null) {
                    conn.close();
                }
                if (pstm != null) {
                    pstm.close();
                }


            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    }

    public void updateCred(int ID, float cred) {
        String sql = "UPDATE students SET cred = ? WHERE ID = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            //criar conexao com o banco
            conn = DB.getConnection();

            //prepared statement pora executar query
            pstm = (PreparedStatement) conn.prepareStatement(sql);

            //preencher os ?
            pstm.setFloat(1, cred);
            pstm.setInt(2, ID);

            //executar query
            pstm.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            try {
                if (conn != null) {
                    conn.close();
                }
                if (pstm != null) {
                    pstm.close();
                }


            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    }

    public void updateDept(int ID, int idDept) {
        String sql = "UPDATE students SET dept = ? WHERE ID = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            //criar conexao com o banco
            conn = DB.getConnection();

            //prepared statement pora executar query
            pstm = (PreparedStatement) conn.prepareStatement(sql);

            //preencher os ?
            pstm.setInt(1, idDept);
            pstm.setInt(2, ID);

            //executar query
            pstm.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            try {
                if (conn != null) {
                    conn.close();
                }
                if (pstm != null) {
                    pstm.close();
                }


            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public void delete(int ID){
        String sql = "DELETE FROM students WHERE ID = ?";


        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            //criar conexao com o banco
            conn = DB.getConnection();

            //prepared statement pora executar query
            pstm = (PreparedStatement) conn.prepareStatement(sql);

            //preencher os ?
            pstm.setInt(1, ID);

            //executar query
            pstm.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            try {
                if (conn != null) {
                    conn.close();
                }
                if (pstm != null) {
                    pstm.close();
                }


            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}

