#include<iostream>
#include<stdio.h>
#include<graphics.h>

using namespace std;
class Matrix{
	public:
		int rows,columns;
		float **arr;
		Matrix(){}
		Matrix(int r,int c){
			rows=r;
			columns=c;
			arr=new float* [r];
			for(int i=0;i<r;i++){
				arr[i]=new float[c];
				for(int j=0;j<c;j++)
					arr[i][j]=0;
			}
		}
		static Matrix multiply(Matrix m1, Matrix m2){
			Matrix m(m1.rows,m2.columns);
			for(int i=0;i<m.rows;i++){
				for(int j=0;j<m.columns;j++){
					for(int k=0;k<m1.columns;k++)
						m.arr[i][j]+=m1.arr[i][k]*m2.arr[k][j];
				}
			}
			return m;
		}
};

int* matrixToArray(Matrix m, int n){
    int *arr = new int[n];
    int i = 0;
    for(int k=0;k<m.columns;k++){
        arr[i] = m.arr[0][k];
        arr[i+1] = m.arr[1][k];
        i+=2;
    }
    arr[i] = m.arr[0][0];
    arr[i+1] = m.arr[1][0];
    return arr;
}

void myPlot(Matrix m, Matrix original){
    int gd = DETECT, gm;
    initgraph(&gd, &gm, NULL);
    int n = (m.rows-1)*(m.columns) + 2;
    int *arr = matrixToArray(m, n);
    int *arr2 = matrixToArray(original, n);
    drawpoly(n/2, arr2);
	setcolor(RED);
    drawpoly(n/2, arr);
	setcolor(GREEN);
	line(25,250,600,250);
	line(300,25,300,450);
    getch();
    closegraph();
}

void translate(Matrix points, Matrix original, int tx, int ty){
    Matrix t(3,3);
    t.arr[0][0] = 1; t.arr[1][1] = 1; t.arr[2][2] = 1; t.arr[0][2] = tx; t.arr[1][2] = ty;
    Matrix res = Matrix::multiply(t, points);
    myPlot(res, Matrix::multiply(t, original));
}

void reflection_x(Matrix m){
	Matrix t(3,3);
	t.arr[0][0] = t.arr[2][2] = 1;
	t.arr[1][1] = -1;
	translate(Matrix::multiply(t,m), m , 150, 250);
}

void reflection_y(Matrix m){
	Matrix t(3,3);
	t.arr[1][1] = t.arr[2][2] = 1;
	t.arr[0][0] = -1;
	translate(Matrix::multiply(t,m), m , 300, 50);
}

int main(){
    // triangle
    Matrix triangle(3,3);
    triangle.arr[0][0] = 200; triangle.arr[1][0] = 50;
    triangle.arr[0][1] = 170; triangle.arr[1][1] = 80;
    triangle.arr[0][2] = 240; triangle.arr[1][2] = 90; 
    for(int i=0;i<triangle.columns;i++)
        triangle.arr[2][i] = 1;

	int choice;

	do{
		cout<<"1. Reflection about x-axis\n2. Reflection about y-axis\nEnter choice: ";
		cin>>choice;
		if(choice==1) reflection_x(triangle);
		else if(choice==2) reflection_y(triangle);
	}while(choice>0 && choice<3);

    return 0;
}