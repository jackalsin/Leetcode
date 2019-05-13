#include <iostream>
#include <string>
#include <algorithm>
#include <vector>
#include <queue>
#include <stack>
#include <unordered_map>
#include <unordered_set>
#include <bitset>
#include <climits>
#include <cmath>

using namespace std;

void dfs(unordered_set<int>& visited,vector<vector<int>> &edges,unordered_set<int> &result,int num,int start,unordered_set<int> visited2)
{
    if(visited2.find(num) != visited2.end())
        return;
    visited2.insert(num);
    visited.insert(num);
    for(int i = 0;i < edges.size();i++)
    {
        if(edges[0] == num)
        {
            int next = edges[1];
            if(result.find(next) != result.end())
            {
                if(next != start)
                    result.erase(next);
            }
            dfs(visited,edges,result,next,start,visited2);
        }
    }
}

void traverse(vector<vector<int>>& edges)
{
    unordered_set<int> result,visited,list,visited2;
    for(int i = 0;i < edges.size();i++)
    {
        list.insert(edges[0]);
        list.insert(edges[1]);
    }
   
    for(int num : list)
    {
        if(visited.find(num) == visited.end())
        {
            result.insert(num);
            dfs(visited,edges,result,num,num,visited2);
        }
    }
    for(int num:result)
        cout<<num<<endl;
   
}



/*
0  1  2  3  4  5  6  7  8  9
0[0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
1[0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
2[0, 0, 0 ,0, 0, 0, 0, 0, 0, 1],
3[0, 0, 0, 1, 0, 1, 0, 1, 0, 0],
4[0, 0, 0, 0, 0, 0 ,0, 0, 1, 0],
5[0, 0, 0, 0, 0, 0, 0, 0, 1, 0],
6[0, 0, 0, 0, 0, 0, 1, 0, 0 ,0],
7[0, 0, 0, 0, 1, 0, 0, 0, 0, 0],
8[0, 0, 0, 0, 0, 0, 0, 1, 0, 0],
9[0, 0, 0, 1, 0, 0, 1, 0, 0, 0]] */


// To execute C++, please define "int main()"
int main() {
    //vector<vector<int>> edges = {{0,1},{1,0},{3,2},{3,1},{2,1}};
    vector<vector<int>> edges = {{2,9},{3,3},{3,5},{3,7},{4,8},{5,8},{6,6},{7,4},{8,7},{9,3},{9,6}};
    traverse(edges);
    return 0;
}