package spielelemente;

public abstract class FassPosition {
	public static int fassXPosition(int i) {
		if(i == 0) {
			return 675;
		} else {
			switch(i%20) {
			case 1: return 48;
			case 2: return 114;
			case 3: return 180;
			case 4: return 246;
			case 5: return 312;
			case 6: return 378;
			case 7: return 444;
			case 8: return 510;
			case 9: return 576;
			case 10: return 642;
			case 11: return 708;
			case 12: return 774;
			case 13: return 840;
			case 14: return 906;
			case 15: return 972;
			case 16: return 1038;
			case 17: return 1104;
			case 18: return 1170;
			case 19: return 1236;
			case 0: return 1302;
			}
		}	
		return 0;
	}
	
	public static int fassYPosition(int i) {
		if(i<=20) return 0;
		else if(i<=40) return 58;
		else if(i<=60) return 116;
		else if(i<=80) return 174;
		else if(i<=100) return 232;
		else if(i<=120) return 290;
		else if(i<=140) return 348;
		else if(i<=160) return 406;
		else if(i<=180) return 464;
		else if(i<=200) return 522;
		return 0;
	}
}
