/**
 * A
 *
 * @author Administrator
 * @date 2019/11/27
 */
public class A {

    public static void main(String[] args) {
        /*FutureTask<Object> futureTask = new FutureTask<>(new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                return null;
            }
        });
        new Thread(futureTask).start();*/

        /*ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<?> submit = executorService.submit(() -> {
        });*/

     /*   AtomicInteger atomicInteger = new AtomicInteger(1);
        for (int i = 0; i < 10; i++) {
            new Thread(() -> System.out.print(atomicInteger.addAndGet(1))).start();
        }*/

 /*       B proxyB = (B) Proxy.newProxyInstance(B.class.getClassLoader(), new Class<?>[]{B.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println(method);
                return null;
            }
        });
        proxyB.b();*/

/*        try {
            String s = "a";
            Field value = String.class.getDeclaredField("value");
            value.setAccessible(true);
            char[] v = (char[]) value.get(s);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }*/

    }
}

/*interface B {
    void b();
}*/
