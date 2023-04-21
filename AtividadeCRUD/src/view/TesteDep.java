package view;

import control.DepartmentCRUD;
import control.InstructorCRUD;
import model.Department;

import java.util.Scanner;

public class TesteDep {
    public static void main(String[] args) {



        InstructorCRUD crudIns = new InstructorCRUD();

        crudIns.showAll();

    }
}
