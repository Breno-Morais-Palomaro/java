package colecoes;

import java.util.HashSet;
import java.util.Set;

public class SetExercise {

	public static void main(String[] args) {
		
		Set<Integer> nums = new HashSet<>();
		
		nums.add(745);
		nums.add(25);
		nums.add(78);
		nums.add(99);
		nums.add(1998);
		nums.add(235);
		
		System.out.println("O numero '1998' existe na coleção? " + nums.contains(1998));
		System.out.println(nums);
		
		System.out.println("Removendo '235' " + nums.remove(235));
		
		System.out.println(nums);
	}
}
