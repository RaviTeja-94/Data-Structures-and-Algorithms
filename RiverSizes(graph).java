import java.util.ArrayList;

class Program {
  public static ArrayList<Integer> riverSizes(int[][] matrix) {
    // Write your code here.
		ArrayList<Integer> riverSizes=new ArrayList<Integer>();
		int size=0;
		boolean[][] visited=new boolean[matrix.length][matrix[0].length];
		for(int i=0;i<matrix.length;i++) {
				for(int j=0;j<matrix[i].length;j++) {
						size=0;
						if(visited[i][j])
							continue;
						size=traverseNeighbouringNodes(i,j,matrix,visited);
						if(size>0)
						riverSizes.add(size);
				}
		}
		return riverSizes;
	}
	
	public static int traverseNeighbouringNodes(int i,int j,int[][] matrix, boolean[][]visited) {
	
		int currentRiverSize=0;
		ArrayList<Integer[]> nodesToExplore=new ArrayList<Integer[]>();
		nodesToExplore.add(new Integer[]{i,j});
		while(!nodesToExplore.isEmpty()) {
				Integer[] curNode=nodesToExplore.get(nodesToExplore.size()-1);
				nodesToExplore.remove(nodesToExplore.size()-1);
				i=curNode[0];
				j=curNode[1];
				if(visited[i][j])
					continue;
				visited[i][j]=true;
				if(matrix[i][j]==0)
					continue;
				currentRiverSize++;
				ArrayList<Integer[]> unnvisitedNeighbours=getUnvisitedNeighbours(i,j,matrix,visited);
				for(Integer[] unvisitedNeighbour:unnvisitedNeighbours)
					nodesToExplore.add(unvisitedNeighbour);
			}
	return currentRiverSize;
	}
	
	public static ArrayList<Integer[]> getUnvisitedNeighbours(int i,int j, int[][] matrix, boolean[][] visited) {
		ArrayList<Integer[]> unnvisitedNeighbours= new 	ArrayList<Integer[]>();
		if(i>0&&!visited[i-1][j])
			unnvisitedNeighbours.add(new Integer[] {i-1, j});
		if(i<matrix.length-1&&!visited[i+1][j])
			unnvisitedNeighbours.add(new Integer[] {i+1, j});
		if(j>0&&!visited[i][j-1])
			unnvisitedNeighbours.add(new Integer[] {i, j-1});
		if(j<matrix[i].length-1&&!visited[i][j+1])
			unnvisitedNeighbours.add(new Integer[] {i, j+1});
		return unnvisitedNeighbours;
	}
	
	
}
