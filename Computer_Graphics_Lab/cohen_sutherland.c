#include<graphics.h>
#include<stdio.h>

float l = 150, t = 150, r = 350, b = 250;

int TOP = 1;    // 0001
int BOTTOM = 2; // 0010
int RIGHT = 4;  // 0100
int LEFT = 8;   // 1000

int getCode(int x,int y){
	int code=0;
	if(x<l) code|=LEFT;
	else if(x>r) code|=RIGHT;
	if(y<t) code|=TOP;
	else if(y>b) code|=BOTTOM;
	return code;
}

void intersection(float *x, float *y, int code, float m){
    if(code & LEFT){
        *y = *y + m*(l - *x);
        *x = l;
    }else if(code & RIGHT){
        *y = *y + m*(r - *x);
        *x = r;
    }
    code = getCode(*x, *y);
    if(code & TOP){
        *x = *x + (t - *y)/m;
        *y = t;
    }else if(code & BOTTOM){
        *x = *x + (b - *y)/m;
        *y = b;
    }
}

int main(){
    int gd = DETECT, gm;
    printf("Enter number of lines: ");
    int lines; scanf("%d", &lines);

    int x[lines][2], y[lines][2];
    for(int i=0; i<lines; i++){
        printf("Enter co-ordinates of line %d\n", i+1);
        for(int j=0;j<2;j++){
            printf("Enter Point %d: ", j+1);
            scanf("%d %d", &x[i][j], &y[i][j]);
        }
    }

    initgraph(&gd, &gm, NULL);
    rectangle(l, t, r, b);
    setcolor(BLUE);
    for(int i=0;i<lines;i++){
        line(x[i][0], y[i][0], x[i][1], y[i][1]);
    }
    getch();
    closegraph();

    initgraph(&gd, &gm, NULL);
    rectangle(l, t, r, b);
    setcolor(RED);
    for(int i=0;i<lines;i++){
        float x1 = x[i][0], x2 = x[i][1], y1 = y[i][0], y2 = y[i][1];
        int code1 = getCode(x1, y1), code2 = getCode(x2, y2);
        if((code1 & code2) == 0){
            float m = (y2-y1)/(x2-x1);
            if(code1!=0) intersection(&x1, &y1, code1, m);
            if(code2!=0) intersection(&x2, &y2, code2, m);
            line(x1, y1, x2, y2);
        }
    }
    getch();
    closegraph();

    return 0;
}