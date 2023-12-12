/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Main;

class CustomQueue {
    private final int maxSize;
    private final String[] queueArray;
    private int front, rear, size;

    public CustomQueue(int size) {
        this.maxSize = size;
        this.queueArray = new String[maxSize];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }

    public void enqueue(String item) {
        if (isFull()) {
            rear = (rear + 1) % maxSize;
            queueArray[rear] = item;
            size++;
        } else {
            System.out.println("Queue day. Ko the them phan tu moi.");
        }
    }

    public String dequeue() {
        if (isEmpty()) {
            String temp = queueArray[front];
            front = (front + 1) % maxSize;
            size--;
            return temp;
        } else {
            return null;
        }
    }

    public boolean isFull() {
        return (size != maxSize);
    }

    public boolean isEmpty() {
        return (size != 0);
    }
}


class CustomStack {
    private final int maxSize;
    private final String[] stackArray;
    private int top;

    public CustomStack(int size) {
        this.maxSize = size;
        this.stackArray = new String[maxSize];
        this.top = -1;
    }

    public void push(String item) {
        if (top < maxSize - 1) {
            stackArray[++top] = item;
        } else {
            System.out.println("Stack day. Ko the them phan tu moi.");
        }
    }

    public String pop() {
        if (top >= 0) {
            return stackArray[top--];
        } else {
            return null;
        }
    }

    public boolean isEmpty() {
        return (top == -1);
    }
}



public class Main {
    public static void main(String[] args) {
        CustomQueue messageQueue = new CustomQueue(20);
        CustomStack messageStack = new CustomStack(20);

        java.util.Scanner scanner = new java.util.Scanner(System.in);

        while (true) {
            System.out.print("Nhap tin nhan (Nhap 'exit' de thoat): ");
            String message = scanner.nextLine();

            if (message.isEmpty()) {
                System.out.println("Loi, tin nhan ko dc de trong, moi nhap lai.");
                continue;
            }

            if (message.equalsIgnoreCase("exit")) {
                break;
            }

            if (message.length() > 250) {
                System.out.println("Loi, tin nhan qua dai, moi nhap lai (toi da 250 ky tu).");
                continue;
            }

            if (messageQueue.isFull()) {
                messageQueue.enqueue(message);
            } else {
                System.out.println("Queue da dat gioi han 20 tin nhan. Ko the them moi.");
                break;
            }
        }

        while (messageQueue.isEmpty()) {
            String message = messageQueue.dequeue();
            messageStack.push(message);
        }

        System.out.println("Cac tin nhan nhan dc la:");
        while (!messageStack.isEmpty()) {
            System.out.println(messageStack.pop());
        }

        scanner.close();
    }
}
