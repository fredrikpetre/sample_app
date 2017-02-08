package com.globalrunners.fpet.cloudrunnerandroid.post;

import android.util.Log;

import com.globalrunners.fpet.cloudrunnerandroid.model.Post;
import com.globalrunners.fpet.cloudrunnerandroid.posts.PostsInteractor;
import com.globalrunners.fpet.cloudrunnerandroid.posts.PostsInteractorImpl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import rx.Scheduler;
import rx.android.plugins.RxAndroidPlugins;
import rx.android.plugins.RxAndroidSchedulersHook;
import rx.functions.Func1;
import rx.observers.TestSubscriber;
import rx.plugins.RxJavaHooks;
import rx.schedulers.Schedulers;

import static org.assertj.core.api.Java6Assertions.assertThat;

//import static org.assertj.core.api.Java6Assertions.*;

/**
 * Created by fpet on 08/02/2017.
 */

public class PostsInteractorTest {

    private PostsInteractor interactor;

    @Before
    public void setUp() {
        RxJavaHooks.setOnIOScheduler(new Func1<Scheduler, Scheduler>() {
            @Override
            public Scheduler call(Scheduler scheduler) {
                return Schedulers.immediate();
            }
        });

        RxJavaHooks.setOnComputationScheduler(new Func1<Scheduler, Scheduler>() {
            @Override
            public Scheduler call(Scheduler scheduler) {
                return Schedulers.immediate();
            }
        });

        RxJavaHooks.setOnNewThreadScheduler(new Func1<Scheduler, Scheduler>() {
            @Override
            public Scheduler call(Scheduler scheduler) {
                return Schedulers.immediate();
            }
        });

        final RxAndroidPlugins rxAndroidPlugins = RxAndroidPlugins.getInstance();
        rxAndroidPlugins.registerSchedulersHook(new RxAndroidSchedulersHook() {
            @Override
            public Scheduler getMainThreadScheduler() {
                return Schedulers.immediate();
            }
        });

        interactor = new PostsInteractorImpl();
    }


    @Test
    public void thatPostListIsNotEmpty() throws Exception{
        TestSubscriber<List<Post>> subscriber = TestSubscriber.create();
        interactor.getPosts().subscribe(subscriber);
        subscriber.assertNoErrors();
        subscriber.assertValueCount(1);
        subscriber.assertCompleted();
        assertThat(subscriber.getOnNextEvents().get(0)).isNotEmpty();
    }

    @Test
    public void thatPostIsNotNull() throws Exception {
        TestSubscriber<List<Post>> subscriber = TestSubscriber.create();
        interactor.getPosts().subscribe(subscriber);
        subscriber.assertNoErrors();
        subscriber.assertValueCount(1);
        subscriber.assertCompleted();
        assertThat(subscriber.getOnNextEvents().get(0).get(0)).isNotNull();
    }

    @After
    public void tearDown() throws Exception {
        RxJavaHooks.reset();
        RxAndroidPlugins.getInstance().reset();
    }
}
