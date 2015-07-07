package easy;
/**
 * Find the total area covered by two rectilinear rectangles in a 2D plane.
 * Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.
 * Assume that the total area is never beyond the maximum possible value of int.
 * @author JieXu
 *
 *///求总体覆盖面积
// first calculate the area of each rectangle
// and then calculate the overlapping area between the two rectangles (if there is one!). 
// At the end, we sum up the individual areas and subtract the overlapping area!
public class RectangleArea {
	public static int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
		int total = (C-A)*(D-B)+(G-E)*(H-F);
		int lefta = Math.max(E, A);
		int leftb = Math.max(B, F);
		int righta = Math.min(C, G);
		int rightb = Math.min(D, H);
		int overlap=0;
		if(righta>lefta && rightb>leftb)  overlap = (righta - lefta)*(rightb - leftb);
		return total - overlap;
	}
	public static void main(String arg[]){
		System.out.println(computeArea(-2, -2, 2, 2, -2, -2, 2, 2));
	}
}
