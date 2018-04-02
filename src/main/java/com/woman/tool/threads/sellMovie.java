package com.woman.tool.threads;
public class sellMovie implements Runnable {
    Model model = new Model();

    @Override
    public void run() {
        while (model.total > 0) {
            synchronized (model) {// 只能鎖引用類型
            
                if (model.total > 0) {
                    System.out.println("銷售票：" + model.total +" "+Thread.currentThread().getName());
                } else {
                    System.out.println("票售完了");
                    return;
                }
                model.total--;
            }
            System.out.println(".............");
        }
    }
}