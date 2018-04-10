package conditionals;

public class condicionales {
	public static void main(String args[]){
//if
		int x = 7;
		if(x < 42){
			System.out.println("Hi");
		}
//if else
		int age = 30;
		if(age < 16){
			System.out.println("Too Young");
		}else{
			System.out.println("Welcome");
		}
//nested if (if anidados)
		age = 25;
		if(age > 0){
			if(age > 16){
				System.out.println("Welcome!");
			}else{
				System.out.println("Too Young");
			}
		}else{
			System.out.println("Error");
		}
//else if
		age = 25;
		if(age <= 0){
			System.out.println("Error");
		}else if(age <= 16){
			System.out.println("Too Young");
		}else if(age < 100){
			System.out.println("Welcome");
		}else{
			System.out.println("Really?");
		}
//Logical Operators
		int money = 1000;
		if(age > 18 && money > 500){		//AND operator &&
			System.out.println("Welcome");
		}
		money = 100;
		if(age > 18 || money > 500){		//OR operator ||
			System.out.println("Welcome");
		}
		if(!(age > 18)){					//NOT operator !
			System.out.println("Too Young");
		}else{
			System.out.println("Welcome");
		}
//switch
		int day = 3;
		switch(day){
		case 1:
			System.out.println("Monday");
			break;
		case 2:
			System.out.println("Tuesday");
			break;
		case 3:
			System.out.println("Wednesday");
			break;
		}
		switch(day){
		case 6:
			System.out.println("Saturday");
			break;
		case 7:
			System.out.println("Sunday");
			break;
		default:
			System.out.println("Weekday");
		}
//while
		x = 3;
		while(x > 0){
			System.out.println(x);
			x--;
		}
//for
		for(x = 1; x <= 5; x++){
			System.out.println(x);
		}
		for(x = 0; x <= 10; x = x + 2){
			System.out.println(x);
		}
//do while
		x = 1;
		do{
			System.out.println(x);
			x++;
		}while(x < 0);
		x = 1;
		while(x > 0){
			System.out.println(x);
			if(x == 4){
				break;
			}
			x++;
		}
		for(x=10; x<=40; x=x+10){
			if(x == 30){
				continue;
			}
			System.out.println(x);
		}
	}
}
