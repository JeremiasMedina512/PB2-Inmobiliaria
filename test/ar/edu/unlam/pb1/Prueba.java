package ar.edu.unlam.pb1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.TreeSet;

public class Prueba {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer contador = 0;
		Departamento departamentoA = new Departamento(1, "Cordero", 123, "Ramos Mejia", 500.0, TipoDeOperacion.ALQUILER, 1,
				1);
		Departamento departamentoB = new Departamento(2, "Cordero", 123, "Ciudadela", 500.0, TipoDeOperacion.ALQUILER, 1, 2);
		Departamento departamentoC = new Departamento(3, "Cordero", 123, "Moron", 500.0, TipoDeOperacion.ALQUILER, 1,
				3);
		Departamento departamentoD = new Departamento(3, "Cordero", 123, "Merlo", 500.0, TipoDeOperacion.ALQUILER, 1,
				3);
		Inmobiliaria inmobiliaria = new Inmobiliaria("Remax", "Varela 123", "example@gmail.com", "123456789");
		inmobiliaria.agregarPropiedad(departamentoA);
		inmobiliaria.agregarPropiedad(departamentoB);
		inmobiliaria.agregarPropiedad(departamentoC);
		inmobiliaria.agregarPropiedad(departamentoD);
		inmobiliaria.agregarPropiedad(departamentoD);
		ArrayList<Departamento> depasA = new ArrayList<Departamento>();
		ArrayList<Departamento> depasACopia = new ArrayList<Departamento>();
		LinkedList<Departamento> depasB = new LinkedList<Departamento>();
		HashSet<Departamento> depasC = new HashSet<Departamento>();
		TreeSet<Departamento> depasD = new TreeSet<>();

		depasA = addDepasArrayList(departamentoA, departamentoB, departamentoC, departamentoD, depasA);
		depasA.add(departamentoD);
//		depasACopia = (ArrayList<Departamento>) depasA.clone();
		depasACopia.addAll(depasA);
		mostrarDepartamentos(depasA);
		System.out.println("Copia");
		mostrarDepartamentos(depasACopia);
		
		depasB = addDepasArrayList(departamentoA, departamentoB, departamentoC, departamentoD, depasB);
		mostrarDepartamentos(depasB);
		
		depasC = addDepasArrayList(departamentoA, departamentoB, departamentoC, departamentoD, depasC);
		depasC.add(departamentoD);
		mostrarDepartamentos(depasC);

		depasD = addDepasArrayList(departamentoA, departamentoB, departamentoC, departamentoD, depasD);
		mostrarDepartamentos(depasD);

	}

	private static TreeSet<Departamento> addDepasArrayList(Departamento departamentoA, Departamento departamentoB,
			Departamento departamentoC, Departamento departamentoD, TreeSet<Departamento> depasD) {
		depasD.add(departamentoA);
		depasD.add(departamentoB);
		depasD.add(departamentoC);
		depasD.add(departamentoD);
		return depasD;
	}

	private static HashSet<Departamento> addDepasArrayList(Departamento departamentoA, Departamento departamentoB,
			Departamento departamentoC, Departamento departamentoD, HashSet<Departamento> depasC) {
		depasC.add(departamentoA);
		depasC.add(departamentoB);
		depasC.add(departamentoC);
		depasC.add(departamentoD);
		return depasC;
	}

	private static LinkedList<Departamento> addDepasArrayList(Departamento a, Departamento b, Departamento c,
			Departamento d, LinkedList<Departamento> depasA) {
		depasA.add(a);
		depasA.add(b);
		depasA.add(c);
		depasA.add(d);
		return depasA;
	}

	private static ArrayList<Departamento> addDepasArrayList(Departamento a, Departamento b, Departamento c,
			Departamento d, ArrayList<Departamento> depasA) {
		depasA.add(a);
		depasA.add(b);
		depasA.add(c);
		depasA.add(d);
		return depasA;
	}

	private static void mostrarDepartamentos(TreeSet<Departamento> departamentos) {
		System.out.println("TreeSet-----------");
		int contador = 0;
		for (Departamento i : departamentos) {
			System.out.println(contador + "| Id: " + i.getCodigo() + ", Fruta: " + i.getCiudad());
			contador++;
		}
		System.out.println("\n");

	}

	private static void mostrarDepartamentos(HashSet<Departamento> departamentos) {
		System.out.println("HashSet-----------");
		int contador = 0;
		for (Departamento i : departamentos) {
			System.out.println(contador + "| Id: " + i.getCodigo() + ", Fruta: " + i.getCiudad());
			contador++;
		}
		System.out.println("\n");

	}

	private static void mostrarDepartamentos(LinkedList<Departamento> departamentos) {
		System.out.println("LinkedList-----------");
		int contador = 0;
		for (Departamento i : departamentos) {
			System.out.println(contador + "| Id: " + i.getCodigo() + ", Fruta: " + i.getCiudad());
			contador++;
		}
		System.out.println("\n");

	}

	private static void mostrarDepartamentos(ArrayList<Departamento> departamentos) {
		System.out.println("ArrayList-----------");
		int contador = 0;
		for (Departamento i : departamentos) {
			System.out.println(contador + "| Id: " + i.getCodigo() + ", Fruta: " + i.getCiudad());
			contador++;
		}
		System.out.println("\n");

	}

	public static LinkedList<Departamento> ordenarElementosDeLinkedList(LinkedList<Departamento> departamentos) {
		for (int i = 0; i < departamentos.size(); i++) {
			for (int j = 0; j < departamentos.size() - 1; j++) {
				if (departamentos.get(j).compareTo(departamentos.get(j + 1)) > 0) {
					Departamento temp = departamentos.get(j);
					departamentos.set(j, departamentos.get(j + 1));
					departamentos.set(j + 1, temp);
				}
			}
		}

		return departamentos;
	}

	public static ArrayList<Departamento> ordenarElementosDeLinkedList(ArrayList<Departamento> departamentos) {
		for (int i = 0; i < departamentos.size(); i++) {
			for (int j = 0; j < departamentos.size() - 1; j++) {
				if (departamentos.get(j).compareTo(departamentos.get(j + 1)) > 0) {
					Departamento temp = departamentos.get(j);
					departamentos.set(j, departamentos.get(j + 1));
					departamentos.set(j + 1, temp);
				}
			}
		}

		return departamentos;
	}

}
