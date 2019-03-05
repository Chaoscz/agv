package com.chao.agv.utils;

import com.chao.agv.entity.ForkliftLine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class Dijkstra {

	
	private static List<Map<Integer, List<Integer>>> cachelist = new ArrayList<>();
	private static Map<String, Integer> cachemap = new HashMap<>();
	private static Map<String, ForkliftLine> cacheremap = new HashMap<>();
	private static List<Integer> cacherelist = new ArrayList<>();
	
	private int[][] graph;// 加权有向图
	private int start;// 源点编号 从 0开始
	private int dimention;
	private static boolean isFirst=true;
	static int INF = Integer.MAX_VALUE / 100;
	// 用于标记顶点是否已经计算
	private Set<Integer> vertexSet = new HashSet<Integer>();
	// 存储结果，Map的key对应各终点编号，value对应路径编号列表。
	private Map<Integer, List<Integer>> pathListMap = new HashMap<Integer, List<Integer>>();

	private List<Map<Integer, List<Integer>>> list = new ArrayList<>();
	
	
	
	
	public List<Map<Integer, List<Integer>>> getList() {
		return list;
	}

	public void setList(List<Map<Integer, List<Integer>>> list) {
		this.list = list;
	}

	public void setPathListMap(Map<Integer, List<Integer>> pathListMap) {
		this.pathListMap = pathListMap;
	}

	/**
	 * 构造函数，必须初始化路径矩阵和起始点
	 * 
	 * @param graph
	 * @param start
	 */
	public Dijkstra(int[][] graph, int start) {
		this.graph = graph;
		this.start = start;
		this.dimention = graph.length;
		calculate();
	}

	/**
	 * 计算函数
	 */
	private void calculate() {
		// 初始化
		for (int end = 0; end < dimention; end++) {
			if (end == start) {
				continue;
			} // 起始点自己的路径排除。
			List<Integer> pathList = new ArrayList<Integer>();
			pathList.add(start);// 每条路径的起始点都为start，pathList只记录编号，不记录路径权值
			pathList.add(end);// 每条路径的第二个参数为终点编号
			pathListMap.put(end, pathList);
		}
		// 计算主体
		for (int bridge = 0; bridge < dimention; bridge++) {
			if (bridge == start) {
				continue;
			}
			if (!vertexSet.contains(bridge)) {// 确保每个基点只循环计算一次
				for (int next = 0; next < dimention; next++) {
					if (next == start || next == bridge) {
						continue;
					}
					int startLen = startTo(bridge);
					int nextLen = startTo(next);
					if (startLen < nextLen) {
						if (getRawLength(bridge, next) !=INF) {
							if (getRawLength(bridge, next)+startTo(bridge) < startTo(next)) {
								List<Integer> pathList = pathListMap.get(next);
								List<Integer> bridgePathList = pathListMap.get(bridge);
								// 清空，使用新的
								pathList.clear();
								pathList.addAll(bridgePathList);
								pathList.add(next);
							}
						}else{
							for (int bridgei = 0; bridgei < dimention; bridgei++) {
								if (bridgei == start ) {
									continue;
								}
								if (next == start) {
									continue;
								}
								if (startTo(bridgei) != INF && getRawLength(bridgei, next) != INF && startTo(next)!= INF ) {
									
									if (startTo(bridgei) + getRawLength(bridgei, next) < startTo(next)) {
										
										List<Integer> pathList = pathListMap.get(next);
										List<Integer> bridgePathList = pathListMap.get(bridgei);
										// 清空，使用新的
										pathList.clear();
										pathList.addAll(bridgePathList);
										pathList.add(next);
									}
								}
								
							}
						}
					}
				}
			}
			vertexSet.add(bridge);
		}
		
		boolean isWhile = true;
		int doTimes = 1;
		do {
			// 检查，是否桥接的路径都被更新
			for (int end = 0; end < dimention; end++) {
				if (end == start) {
					continue;
				}
				List<Integer> pathList = pathListMap.get(end);
				int size = pathList.size();
				if (size > 2) {
					for (int end2 = 0; end2 < dimention; end2++) {
						if(size != pathList.size()){
							size = pathList.size();
						}
						int isEnd = pathList.get(size - 2);
						if (end2 == isEnd) {
							if (getRawLength(end2,pathList.get(pathList.size()-1)) != INF) {
								
								pathList.clear();
								pathList.addAll(pathListMap.get(end2));
								pathList.add(end);
							}
						}
					}
				}else{
					if (getRawLength(pathList.get(0), pathList.get(1)) == INF) {
						int starti = pathList.get(0);
						int next = pathList.get(1);
						for (int bridgei = 0; bridgei < dimention; bridgei++) {
							if (bridgei == starti ) {
								continue;
							}
							if (next == starti && next == bridgei) {
								continue;
							}
							
							if (startTo(bridgei) + getRawLength(bridgei, next) < startTo(next)) {
								
								List<Integer> pathListi = pathListMap.get(next);
								List<Integer> bridgePathList = pathListMap.get(bridgei);
								pathListi.clear();
								pathListi.addAll(bridgePathList);
								pathListi.add(next);
							}
						}
					} 
				}
			}
			
			for (int end = 0; end < dimention; end++) {
				if (end == start) {
					continue;
				}
				if (startTo(end) == INF) {
					isWhile = true;
					break;
				}
				if (end == (dimention-1)) {
					isWhile = false;
				}
			}
			
			doTimes++;
			if (doTimes > dimention) {
				isWhile = false;
			}
		} while (isWhile);
	}

	/**
	 * 获取当前指定路径的长度
	 * 
	 * @param start
	 * @param end
	 * @return
	 */
	private int startTo(int end) {
		int pathLen = 0;
		List<Integer> pathList = pathListMap.get(end);
		for (int i = 0; i < pathList.size() - 1; i++) {
			if (graph[pathList.get(i)][pathList.get(i + 1)] == INF) {
				return INF;
			}
			pathLen += graph[pathList.get(i)][pathList.get(i + 1)];
		}
		if (pathLen == INF) {
		}
		return pathLen;
	}

	/**
	 * 直接提取矩阵中的相邻路径。
	 * 
	 * @param start
	 * @param end
	 * @return
	 */
	private int getRawLength(int start, int end) {
		if (end == start) {
			return 0;
		}
		return graph[start][end];
	}

	/**
	 * 得到指定目标的路劲长度
	 * 
	 * @param end
	 * @return
	 */
	public int getLength(int end) {
		if (end == start) {
			return 0;
		}
		return startTo(end);
	}

	/**
	 * 在控制台打印输出所有路径编号
	 */
	public Map<Integer, List<Integer>> printResult() {
		list.add(pathListMap);
		return pathListMap;
		
	}

	/**
	 * 所有路径编号
	 * 
	 * @return
	 */
	public Map<Integer, List<Integer>> getPathListMap() {
		return pathListMap;
	}
	

	/**
	 * 获取线起点终点数据集合
	 * @param graph 顶点二维数组
	 * @param startSite 起点数组下标
	 * @param endSite 终点数据下标
	 * @return
	 */
	public static List<ForkliftLine> getPathInt(List<ForkliftLine> lines,int startSite,int endSite){
		int start =0;
		int end = 0;
		int oldEnd = endSite;
		long startTime = System.currentTimeMillis();
		List<Map<Integer, List<Integer>>> list = new ArrayList<>();
		Map<String, Integer> map = new HashMap<>();
		Map<String, ForkliftLine> remap = new HashMap<>();
		List<Integer> relist = new ArrayList<>();
		isFirst = true;
		if (isFirst) {
			isFirst = false;
			for (ForkliftLine l : lines) {
				remap.put(l.getStartSiteCode()+"-"+l.getEndSiteCode(), l);
				if (!relist.contains(l.getStartSiteCode())) {
					relist.add(l.getStartSiteCode());
				}
				if (!relist.contains(l.getEndSiteCode())) {
					relist.add(l.getEndSiteCode());
				}
			}

			startSite = relist.lastIndexOf(startSite);
			endSite = relist.lastIndexOf(endSite);
			if (startSite == -1 || endSite == -1) {
				return null;
			}
			int[][] graph = new int[relist.size()][relist.size()];
			for (int i = 0; i < relist.size(); i++) {
				for (int j = 0; j < relist.size(); j++) {
					// 在线体中取步数
					if(null!=remap.get(relist.get(i)+"-"+relist.get(j)) && remap.get(relist.get(i)+"-"+relist.get(j)).getStepNumber() != null){
						graph[i][j]=Math.abs(remap.get(relist.get(i)+"-"+relist.get(j)).getStepNumber());
					}else {
						graph[i][j]=INF;
					}
					
				}
			}
			
			int length = graph.length;
			start = startSite;
			Dijkstra dijkstra = new Dijkstra(graph, start);
			list.add(dijkstra.printResult());
			for (end = 0; end < length; end++) {
				if (end == start) {
					continue;
				}
				int len = dijkstra.getLength(end);
				map.put(String.valueOf(start)+"-"+String.valueOf(end), len);
			}
			cachelist = list;
			cachemap = map;
			cacheremap = remap;
			cacherelist = relist;
		} else {
			list = cachelist;
			map = cachemap;
			remap=cacheremap;
			relist=cacherelist;
			startSite = relist.lastIndexOf(startSite);
			endSite = relist.lastIndexOf(endSite);
			if (startSite == -1 || endSite == -1) {
				return null;
			}
		}
		List<Integer> resInt = list.get(0).get(endSite);
		
		long endTime = System.currentTimeMillis();
		List<ForkliftLine> reLines = new ArrayList<>();
		for (int i = 0; i < resInt.size(); i++) {
			if (i < resInt.size()-1) {
				ForkliftLine line = remap.get(relist.get(resInt.get(i))+"-"+relist.get(resInt.get(i+1)));
				if (line == null) {
					return null;
				}
				reLines.add(remap.get(relist.get(resInt.get(i))+"-"+relist.get(resInt.get(i+1))));
			}
		}
		return reLines;
	}
	
	public static void resetFlag(){
		isFirst=true;
	}
	
	public static boolean getFlag(){
		return isFirst;
	}
}