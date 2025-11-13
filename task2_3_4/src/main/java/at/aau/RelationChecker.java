package at.aau;

public class RelationChecker {
    public static int checkRelation(int x, int y) {
		int u, v, w;
		if (x < y) {
			u = y; // u = 17
			w = 2;
		} else {
			u = x;
			w = 0;
		}
		if (x + y < 25) {
			v = u + y;
		} else {
			v = u + x / w; // = 17+10/2=22
		}
		return v;
	}
}