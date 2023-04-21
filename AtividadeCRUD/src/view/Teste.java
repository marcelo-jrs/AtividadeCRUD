package view;

import control.DepartmentCRUD;
import control.InstructorCRUD;
import control.StudentCRUD;
import model.Department;
import model.Instructor;
import model.Student;

import java.util.Scanner;

public class Teste {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        DepartmentCRUD crudDep = new DepartmentCRUD();
        InstructorCRUD crudIns = new InstructorCRUD();
        StudentCRUD crudStu = new StudentCRUD();

        System.out.println("Deseja usar qual tabela?");
        System.out.println("Digite 1 para Departamento");
        System.out.println("Digite 2 para Instrutor");
        System.out.println("Digite 3 para Estudante");
        int escolhaTabela = 0;
        escolhaTabela = input.nextInt();

        switch (escolhaTabela){
            case 1:

                //DEPARTAMENTO

                System.out.println("Digite 1 para criar um novo");
                System.out.println("Digite 2 para ver todos os cadastrados");
                System.out.println("Digite 3 para ver apenas um cadastro");
                System.out.println("Digite 4 para alterar um cadastro");
                System.out.println("Digite 5 para deletar um cadastro");
                int escolhaTarefa = 0;
                escolhaTarefa = input.nextInt();

                switch (escolhaTarefa){
                    case 1:
                        System.out.println("Insira o nome do departamento");
                        String deptName = input.next();
                        System.out.println("Insira o prédio do departamento");
                        String building = input.next();
                        System.out.println("Insira o orçamento do departamento");
                        float budget = input.nextFloat();
                        Department dep = new Department(deptName, building, budget);
                        crudDep.save(dep);
                        break;
                    case 2:
                        crudDep.showAll();
                        break;
                    case 3:
                        System.out.println("Insira o ID do departamento");
                        int ID = input.nextInt();
                        crudDep.showById(ID);
                        break;
                    case 4:
                        System.out.println("Digite 1 para alterar o nome");
                        System.out.println("Digite 2 para alterar o prédio");
                        System.out.println("Digite 3 para alterar o orçamento");
                        int escolhaUpdate = input.nextInt();

                        switch (escolhaUpdate) {
                            case 1:
                                System.out.println("Insira o ID do departamento que deseja atualizar");
                                int IDupdate = input.nextInt();
                                System.out.println("Insira o novo nome");
                                String newName = input.next();

                                crudDep.updateDeptName(IDupdate,newName);
                                break;
                            case 2:
                                System.out.println("Insira o ID do departamento que deseja atualizar");
                                IDupdate = input.nextInt();
                                System.out.println("Insira o novo prédio");
                                String newBuilding = input.next();

                                crudDep.updateBuilding(IDupdate, newBuilding);
                                break;
                            case 3:
                                System.out.println("Insira o ID do departamento que deseja atualizar");
                                IDupdate = input.nextInt();
                                System.out.println("Insira o novo orçamento");
                                float newBudget = input.nextFloat();

                                crudDep.updateBudget(IDupdate, newBudget);
                                break;
                            default:
                                System.out.println("FIM");
                                break;
                        }
                        break;

                    case 5:
                        System.out.println("Insira o ID do departamento que deseja deletar");
                        int IDdelete = input.nextInt();

                        crudDep.delete(IDdelete);
                        break;
                    default:
                        System.out.println("FIM");
                        break;
                }
                break;

            case 2:

                //INSTRUTOR

                System.out.println("Digite 1 para criar um novo");
                System.out.println("Digite 2 para ver todos os cadastrados");
                System.out.println("Digite 3 para ver apenas um cadastro");
                System.out.println("Digite 4 para alterar um cadastro");
                System.out.println("Digite 5 para deletar um cadastro");
                escolhaTarefa = 0;
                escolhaTarefa = input.nextInt();

                switch (escolhaTarefa){
                    case 1:
                        System.out.println("Insira o nome do instrutor");
                        String name = input.next();
                        System.out.println("Insira o departamento do instrutor");
                        String deptName = input.next();
                        System.out.println("Insira o salário do instrutor");
                        float salary = input.nextFloat();

                        int deptId = crudDep.getId(deptName);

                        Instructor ins = new Instructor(name, deptId, salary);
                        crudIns.save(ins);
                        break;
                    case 2:
                        crudIns.showAll();
                        break;
                    case 3:
                        System.out.println("Insira o ID do instrutor");
                        int ID = input.nextInt();
                        crudIns.showById(ID);
                        break;
                    case 4:
                        System.out.println("Digite 1 para alterar o nome");
                        System.out.println("Digite 2 para alterar o departamento");
                        System.out.println("Digite 3 para alterar o salário");
                        int escolhaUpdate = input.nextInt();

                        switch (escolhaUpdate) {
                            case 1:
                                System.out.println("Insira o ID do instrutor que deseja atualizar");
                                int IDupdate = input.nextInt();
                                System.out.println("Insira o novo nome");
                                String newName = input.next();

                                crudIns.updateName(IDupdate,newName);
                                break;
                            case 2:
                                System.out.println("Insira o ID do instrutor que deseja atualizar");
                                IDupdate = input.nextInt();
                                System.out.println("Insira o ID do novo departamento");
                                crudDep.showAll();
                                int newDept = input.nextInt();

                                crudIns.updateDept(IDupdate, newDept);
                                break;
                            case 3:
                                System.out.println("Insira o ID do instrutor que deseja atualizar");
                                IDupdate = input.nextInt();
                                System.out.println("Insira o novo salário");
                                float newSalary = input.nextFloat();

                                crudIns.updateSalary(IDupdate, newSalary);
                                break;
                            default:
                                System.out.println("FIM");
                                break;
                        }
                        break;

                    case 5:
                        System.out.println("Insira o ID do instrutor que deseja deletar");
                        int IDdelete = input.nextInt();

                        crudIns.delete(IDdelete);
                        break;
                }
                break;

            case 3:

                //ESTUDANTE

                System.out.println("Digite 1 para criar um novo");
                System.out.println("Digite 2 para ver todos os cadastrados");
                System.out.println("Digite 3 para ver apenas um cadastro");
                System.out.println("Digite 4 para alterar um cadastro");
                System.out.println("Digite 5 para deletar um cadastro");
                escolhaTarefa = 0;
                escolhaTarefa = input.nextInt();

                switch (escolhaTarefa){
                    case 1:
                        System.out.println("Insira o nome do estudante");
                        String name = input.next();
                        System.out.println("Insira o departamento do estudante");
                        String deptName = input.next();
                        System.out.println("Insira o crédito do estudante");
                        float cred = input.nextFloat();

                        int deptId = crudDep.getId(deptName);

                        Student stu = new Student(name, deptId, cred);
                        crudStu.save(stu);
                        break;
                    case 2:
                        crudStu.showAll();
                        break;
                    case 3:
                        System.out.println("Insira o ID do estudante");
                        int ID = input.nextInt();
                        crudStu.showById(ID);
                        break;
                    case 4:
                        System.out.println("Digite 1 para alterar o nome");
                        System.out.println("Digite 2 para alterar o departamento");
                        System.out.println("Digite 3 para alterar o crédito");
                        int escolhaUpdate = input.nextInt();

                        switch (escolhaUpdate) {
                            case 1:
                                System.out.println("Insira o ID do estudante que deseja atualizar");
                                int IDupdate = input.nextInt();
                                System.out.println("Insira o novo nome");
                                String newName = input.next();

                                crudStu.updateName(IDupdate,newName);
                                break;
                            case 2:
                                System.out.println("Insira o ID do estudante que deseja atualizar");
                                IDupdate = input.nextInt();
                                System.out.println("Insira o ID do novo departamento");
                                crudDep.showAll();
                                int newDept = input.nextInt();

                                crudStu.updateDept(IDupdate, newDept);
                                break;
                            case 3:
                                System.out.println("Insira o ID do estudante que deseja atualizar");
                                IDupdate = input.nextInt();
                                System.out.println("Insira o novo crédito");
                                float newCred = input.nextFloat();

                                crudStu.updateCred(IDupdate, newCred);
                                break;
                            default:
                                System.out.println("FIM");
                                break;
                        }
                        break;

                    case 5:
                        System.out.println("Insira o ID do estudante que deseja deletar");
                        int IDdelete = input.nextInt();

                        crudStu.delete(IDdelete);
                        break;
                }
                break;
        }
    }
}
