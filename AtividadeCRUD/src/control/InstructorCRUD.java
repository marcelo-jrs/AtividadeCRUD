package control;

import com.mysql.jdbc.PreparedStatement;
import model.Department;
import model.Instructor;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Integer.parseInt;

public class InstructorCRUD {

    public int getId(String name) {
        String sql = "SELECT ID FROM instructors WHERE dept = ?";

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

    public void save(Instructor instructor){
        String sql = "INSERT INTO instructors (name, dept, salary) VALUES (?, ?, ?)";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            //criar conexao com o banco
            conn = DB.getConnection();

            //prepared statement pora executar query
            pstm = (PreparedStatement) conn.prepareStatement(sql);

            //preencher os ?
            pstm.setString(1, instructor.getName());
            pstm.setInt(2, instructor.getDept());
            pstm.setFloat(3, instructor.getSalary());

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
        String sql = "SELECT * FROM instructors";

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
                float salary = result.getFloat(4);

                DepartmentCRUD crudDep = new DepartmentCRUD();

                Department dep = crudDep.getById(dept);

                String deptName = dep.getDeptName();

                System.out.println(ID + "\t\t" + name
                        + "\t\t" + deptName + "\t\t" + salary);


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

        String sql = "SELECT * FROM instructors WHERE ID = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            //criar conexao com o banco
            conn = DB.getConnection();

            //prepared statement pora executar query
            pstm = (PreparedStatement) conn.prepareStatement(sql);

            pstm.setInt(1, ID);

            //executar query
            ResultSet result = pstm.executeQuery();


            while (result.next()) {

                int IDins = result.getInt(1);
                String name = result.getString(2);
                int IDdept = result.getInt(3);
                float salary = result.getFloat(4);

                DepartmentCRUD crudDep = new DepartmentCRUD();

                Department dep = crudDep.getById(IDdept);

                String deptName = dep.getDeptName();

                System.out.println(IDins + "\t\t" + name
                        + "\t\t" + deptName + "\t\t" + salary);

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
        String sql = "UPDATE instructors SET name = ? WHERE ID = ?";


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

    public void updateSalary(int ID, float salary) {
        String sql = "UPDATE instructors SET salary = ? WHERE ID = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            //criar conexao com o banco
            conn = DB.getConnection();

            //prepared statement pora executar query
            pstm = (PreparedStatement) conn.prepareStatement(sql);

            //preencher os ?
            pstm.setFloat(1, salary);
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
        String sql = "UPDATE instructors SET dept = ? WHERE ID = ?";

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
        String sql = "DELETE FROM instructors WHERE ID = ?";


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
