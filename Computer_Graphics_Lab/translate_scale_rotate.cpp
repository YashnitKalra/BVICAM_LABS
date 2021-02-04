#include<iostream>
#include<graphics.h>
#include<math.h>
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
        void print(){
			for(int i=0;i<rows;i++){
				cout<<"[ ";
				for(int j=0;j<columns;j++)
					cout<<arr[i][j]<<" ";
				cout<<"]\n";
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

void myPlot(Matrix m){
    int gd = DETECT, gm;
    initgraph(&gd, &gm, NULL);
    int n = (m.rows-1)*(m.columns) + 2;
    int *arr = matrixToArray(m, n);
    // for(int i=0;i<n;i++)
    //     cout<<arr[i]<<" ";
    drawpoly(n/2, arr);
    getch();
    closegraph();
}

void translate(Matrix points){
    float tx,ty;
    cout<<"Enter tx: "; cin>>tx; cout<<"Enter ty: "; cin>>ty;
    Matrix t(3,3);
    t.arr[0][0] = 1; t.arr[1][1] = 1; t.arr[2][2] = 1; t.arr[0][2] = tx; t.arr[1][2] = ty;
    Matrix res = Matrix::multiply(t, points);
    myPlot(res);
}

void scale(Matrix points){
    float sx,sy;
    cout<<"Enter sx: "; cin>>sx; cout<<"Enter sy: "; cin>>sy;
    Matrix t(3,3);
    t.arr[0][0] = sx; t.arr[1][1] = sy; t.arr[2][2] = 1;
    Matrix res = Matrix::multiply(t, points);
    myPlot(res);
}

void rotation(Matrix points){
    float theta;
    cout<<"Enter angle: "; cin>>theta;
    theta = theta * 3.14 / 180;
    Matrix t(3,3);
    t.arr[0][0]=cos(theta); t.arr[0][1]=-sin(theta);
	t.arr[1][0]=sin(theta); t.arr[1][1]=cos(theta);
    t.arr[2][2] = 1;
    Matrix res = Matrix::multiply(t, points);
    myPlot(res);
}

int main(){
    string menu1 = "\n1. Translate\n2. Scale\n3. Rotate\nEnter choice: ";
    string menu2 = "\n1. Line\n2. Triangle\n3. Square\nEnter choice: ";
    
    // line
    Matrix line(3,2); line.arr[0][0] = 100; line.arr[1][0] = 50; line.arr[0][1] = 150; line.arr[1][1] = 100;
    for(int i=0;i<line.columns;i++)
        line.arr[2][i] = 1;
    
    // circ
    Matrix triangle(3,3);
    triangle.arr[0][0] = 200; triangle.arr[1][0] = 50;
    triangle.arr[0][1] = 170; triangle.arr[1][1] = 80;
    triangle.arr[0][2] = 240; triangle.arr[1][2] = 90; 
    for(int i=0;i<triangle.columns;i++)
        triangle.arr[2][i] = 1;

    // square
    Matrix square(3,4);
    square.arr[0][0] = 20; square.arr[1][0] = 20;
    square.arr[0][1] = 42; square.arr[1][1] = 20;
    square.arr[0][2] = 42; square.arr[1][2] = 42;
    square.arr[0][3] = 20; square.arr[1][3] = 42;
    for(int i=0;i<square.columns;i++)
        square.arr[2][i] = 1;
    
    int choice1, choice2;
    do{
        Matrix temp;
        cout<<menu1; cin>>choice1;
        if(choice1>0 && choice1<4){
            cout<<menu2; cin>>choice2;
            if(choice2==1) temp = line;
            else if(choice2==2) temp = triangle;
            else if(choice2==3) temp = square;
        }

        switch(choice1){
            case 1:
                myPlot(temp); translate(temp); break;
            case 2:
                myPlot(temp); scale(temp); break;
            case 3:
            myPlot(temp); rotation(temp); break;
                break;
        }
    }while(choice1>0 && choice1<4);
    return 0;
}