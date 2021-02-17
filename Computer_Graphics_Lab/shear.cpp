#include<iostream>
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
    setcolor(GREEN);
    drawpoly(n/2, arr);
    setcolor(RED);
    drawpoly(n/2, arr2);
    getch();
    closegraph();
}

void shear_x(Matrix m){
    cout<<"Enter h: "; int h; cin>>h;
	Matrix t(3,3);
	t.arr[0][0] = t.arr[1][1] = t.arr[2][2] = 1;
	t.arr[0][1] = h;
	myPlot(m, Matrix::multiply(t,m));
}

void shear_y(Matrix m){
    cout<<"Enter h: "; int h; cin>>h;
	Matrix t(3,3);
	t.arr[0][0] = t.arr[1][1] = t.arr[2][2] = 1;
	t.arr[1][0] = h;
	myPlot(m, Matrix::multiply(t,m));
}

int main(){
    Matrix polygon(3,4);
    polygon.arr[0][0] = 100; polygon.arr[1][0] = 0;
    polygon.arr[0][1] = 100; polygon.arr[1][1] = 100;
    polygon.arr[0][2] = 0; polygon.arr[1][2] = 100;
    polygon.arr[0][3] = 0; polygon.arr[1][3] = 0; 
    for(int i=0;i<polygon.columns;i++)
        polygon.arr[2][i] = 1;

	int choice;

	do{
		cout<<"1. Shear-x\n2. Shear-y\nEnter choice: ";
		cin>>choice;
		if(choice==1) shear_x(polygon);
		else if(choice==2) shear_y(polygon);
	}while(choice>0 && choice<3);

    return 0;
}