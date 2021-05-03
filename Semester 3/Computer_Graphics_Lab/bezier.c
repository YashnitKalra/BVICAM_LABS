#include<graphics.h>
#include<stdio.h>
#include<math.h>

void bezier(int x[4], int y[4]){

    int gd = DETECT, gm;
    initgraph(&gd, &gm, NULL);

    double temp_x, temp_y;
    for(double t=0;t<1;t+=0.0005){
        temp_x = (pow(1-t,3)*x[0])+(3*t*pow(1-t,2)*x[1])+(3*pow(t,2)*(1-t)*x[2])+(pow(t,3)*x[3]);
        temp_y = (pow(1-t,3)*y[0])+(3*t*pow(1-t,2)*y[1])+(3*pow(t,2)*(1-t)*y[2])+(pow(t,3)*y[3]);
        putpixel(temp_x, temp_y, BLUE);
    }

    for(int i=0;i<4;i++){
        putpixel(x[i], y[i], RED);
    }

    getch();
    closegraph();
}

int main(){
    int x[4], y[4];
    for(int i=0;i<4;i++){
        printf("Enter Point %d: ", i+1);
        scanf("%d %d", &x[i], &y[i]);
    }
    bezier(x,y);
    return 0;
}