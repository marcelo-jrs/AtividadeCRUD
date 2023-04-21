package control;

import com.mysql.jdbc.PreparedStatement;
import model.Department;

import java.security.GeneralSecurityException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;

public class DepartmentCRUD {

    public int getId(String deptName) {
        String sql = "SELECT ID FROM department WHERE deptName = ?";

        Connection conn = null;
        PreparedStatement pstm = null;
        int ID = 0;

        try {
            //criar conexao com o banco
            conn = DB.getConnection();

            //prepared statement pora executar query
            pstm = (PreparedStatement) conn.prepareStatement(sql);

            //preencher os ?
            pstm.setString(1, deptName);

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

    public void save(Department department) {
        String sql = "INSERT INTO department (deptName,building, budget) VALUES (?, ?, ?)";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            //criar conexao com o banco
            conn = DB.getConnection();

            //prepared statement pora executar query
            pstm = (PreparedStatement) conn.prepareStatement(sql);

            //preencher os ?
            pstm.setString(1, department.getDeptName());
            pstm.setString(2, department.getBuilding());
            pstm.setFloat(3, department.getBudget());

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

    public void showAll() {
        String sql = "SELECT * FROM department";

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
                String deptName = result.getString(2);
                String building = result.getString(3);
                float budget = result.getFloat(4);

                System.out.println(ID + "\t\t" + deptName
                        + "\t\t" + building + "\t\t" + budget);

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

        String sql = "SELECT * FROM department WHERE ID = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        Department dep = null;

        try {
            //criar conexao com o banco
            conn = DB.getConnection();

            //prepared statement pora executar query
            pstm = (PreparedStatement) conn.prepareStatement(sql);

            pstm.setInt(1, ID);

            //executar query
            ResultSet result = pstm.executeQuery();


            while (result.next()) {

                String IDdept = result.getString(1);
                String deptName = result.getString(2);
                String building = result.getString(3);
                float budget = result.getFloat(4);

                System.out.println(IDdept + "\t\t" + deptName
                        + "\t\t" + building + "\t\t" + budget);

                dep = new Department(deptName, building, budget);

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

    public Department getById(int ID) {

        String sql = "SELECT * FROM department WHERE ID = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        Department dep = null;

        try {
            //criar conexao com o banco
            conn = DB.getConnection();

            //prepared statement pora executar query
            pstm = (PreparedStatement) conn.prepareStatement(sql);

            pstm.setInt(1, ID);

            //executar query
            ResultSet result = pstm.executeQuery();


            while (result.next()) {

                String IDdept = result.getString(1);
                String deptName = result.getString(2);
                String building = result.getString(3);
                float budget = result.getFloat(4);

                dep = new Department(deptName, building, budget);

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

        return dep;

    }

    public void updateBuilding(int ID, String newBuilding) {
        String sql = "UPDATE department SET building = ? WHERE ID = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            //criar conexao com o banco
            conn = DB.getConnection();

            //prepared statement pora executar query
            pstm = (PreparedStatement) conn.prepareStatement(sql);

            //preencher os ?
            pstm.setString(1, newBuilding);
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

    public void updateBudget(int ID, float budget) {
        String sql = "UPDATE department SET budget = ? WHERE ID = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            //criar conexao com o banco
            conn = DB.getConnection();

            //prepared statement pora executar query
            pstm = (PreparedStatement) conn.prepareStatement(sql);

            //preencher os ?
            pstm.setFloat(1, budget);
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

    public void updateDeptName(int ID, String deptName) {
        String sql = "UPDATE department SET deptName = ? WHERE ID = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            //criar conexao com o banco
            conn = DB.getConnection();

            //prepared statement pora executar query
            pstm = (PreparedStatement) conn.prepareStatement(sql);

            //preencher os ?

            pstm.setString(1, deptName);
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
        String sql = "DELETE FROM department WHERE ID = ?";


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
