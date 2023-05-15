#include <iostream>
#include <chrono>
using namespace std;


long long fibo(int n) {
    if (n <= 1)
        return n;
    return fibo(n - 1) + fibo(n - 2);
}//재귀알고리즘


long long fibo_for(int n) {
    long long a = 0, b = 1, sum= 1;
    if (n == 1)
        return a;
    else if (n == 2)
        return b;
    else {
        for (int i = 0; i < n - 2; ++i) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return sum;
    }
}//반복 알고리즘

int main() {
    int n = 10;
    long long tmp;
    chrono::time_point<chrono::high_resolution_clock> start, end;
    chrono::duration<double, nano> time;
    while (true) {
        start = chrono::high_resolution_clock::now();
        tmp = fibo(n);
        end = chrono::high_resolution_clock::now();
        time = end - start;
        // 재귀함수가 돌아가고 난 후 시간 체크

        if (time.count() > 600000000) {
            cout << "재귀함수에서 10분이상 소요됨";
            break;
        }
        cout << "재귀함수 걸린시간 : " << time.count() << "ns\n";

        start = chrono::high_resolution_clock::now();
        tmp = fibo_for(n);
        end = chrono::high_resolution_clock::now();
        time = end - start;
        // 반복함수가 돌아가고 난 후 시간 체크

        if (time.count() > 600000000) {
            cout << "반복함수에서 10분이상 소요됨";
            break;
        }
        cout << "반복함수 걸린 시간 : " << time.count() << "ns\n";

        n = n + 10;
    }
    return 0;
}
