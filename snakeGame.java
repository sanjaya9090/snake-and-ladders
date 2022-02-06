import java.util.*;
class snakeGame{
	static void wai(int a){
		try{
			if (a==1)
				Thread.sleep(400);
			else if (a==2){
				Thread.sleep(1000);
				System.out.println();
			}
		}
		catch(InterruptedException e) {
			System.out.print("Got Some Error");
		}
	}
	
	static int rollDice(String player){
		Random r=new Random();
		wai(1);
		int dc,d=r.nextInt(6)+1;
		dc=d;
		System.out.println(player +" got " +d);
		if (d==6){
			wai(1);
			d=r.nextInt(6)+1;
			dc+=d;
			System.out.println(player +" got " + d + " in second roll and total "+dc);
			if (d==6){
				wai(1);
				d=r.nextInt(6)+1;
				if(d!=6){
					dc+=d;
					System.out.println(player +" got " + d +" in third roll and total "+dc);
				}
				else {
					System.out.println("Sorry , "+player +" You got " + d +" in third roll too and total become 0");
					dc=0;
				}
			}
		}
		return dc;
	}
	
	static int checkLad(int score){
		if (score==4) return 14;
		else if (score==9) return 31;
		else if (score==20) return 38;
		else if (score==28) return 84;
		else if (score==40) return 89;
		else if (score==51) return 67;
		else if (score==63) return 81;
		else return score;
	}
	
	static int checkSnake(int score){
		if(score==17) return 7;
		else if (score==89) return 26;
		else if (score==64) return 60;
		else if (score==95) return 75;
		else if (score==99) return 78;
		else return score;
	}
	
	static String getName(){
		Scanner s= new Scanner(System.in);
		return s.nextLine();
	}
	
	static void startGame(){
		Scanner s = new Scanner(System.in);
		System.out.print("Enter number of Player (<=4) : " );
		int n;
		String p1="",p2="",p3="",p4="";
		while(true){
			n=s.nextInt();
			if (n<1 || n>4) {
				System.out.print("Enter valid Input : ");
				continue;
			}
			else if(n==1){
				System.out.print("Enter name of Player : " );
				p1=getName();
				p2="Sanjay";
				n=2;
				break;
			}
			else if (n>1){
				System.out.print("Enter name of Player 1: " );
				p1 = getName();
				System.out.print("Enter name of Player 2: " );
				p2 = getName();
				if (n>2){
					System.out.print("Enter name of Player 3: " );
					p3=getName();
					if (n>3){
						System.out.print("Enter name of Player 4: " );
						p4=getName();
					}
				}
				break;
			}
		}
		StartPlaying(n,p1,p2,p3,p4);
		
	}
	
	static void StartPlaying(int n,String p1,String p2,String p3,String p4){
		int s1=0,s2=0,s3=0,s4=0;
		while(true){
			if (n>1){
				s1=ply(p1,s1);
				if (s1==100) break;
				
				s2=ply(p2,s2);
				if (s2==100) break;
				
				if (n>2){
					s3=ply(p3,s3);
					if (s3==100) break;
					if (n>3){
						s4=ply(p4,s4);
						if (s4==100) break;
					}
				}
			}
		}
		System.out.print("Enter 1 to play once more : ");
		int c= new Scanner(System.in).nextInt();
		if (c==1 ) StartPlaying(n,p1,p2,p3,p4);
	}
	
	static int ply(String pname,int sc){
		wai(2);
		System.out.println(pname +" Your Turn. Currently you're at "+sc);
		int rc=sc;
		rc+=rollDice(pname);
		if (rc==100){
			System.out.println("Congrats,"+pname +" You Won the Game.");
			return rc;
		}
		else if(rc<100){
			int lc=checkLad(rc),ss=checkSnake(rc);
			if(lc!=rc){
				System.out.println("Congrats ,"+pname+" You got Ladder from "+rc+" to "+lc);
				return lc;
			}
			else if(ss!=rc){
				System.out.println("Oh, No "+pname+" Snake taken you from "+rc+" to "+ss);
				return ss;
			}
			else {
				System.out.println(pname +" You're now at "+rc);
				return rc;
			}
		}
		else {
			System.out.println("Sorry ! "+pname +" You Can't Move ");
		}
		return sc;
	}
	
	public static void main(String sm[]){
		startGame();
		
	}
	
}