Welcome RaselLibrary 

Step 1: settings.gradle ফাইলে রিপোজিটরি যোগ করুন
আপনার প্রজেক্টের রুট লেভেলের settings.gradle ফাইলের repositories блоকে JitPack যুক্ত করুন:

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven { url 'https://jitpack.io' } // এটি যোগ করতে হবে
    }
}


Step 2: ডিপেন্ডেন্সি যুক্ত করুন
যে প্রজেক্টে লাইব্রেরিটি ব্যবহার করতে চান, সেটির অ্যাপ লেভেলের build.gradle ফাইলের dependencies-এ এই এক লাইন বসিয়ে দিন:

dependencies {
    implementation 'com.github.myumsoft:Rasel_Library:1.0.0'
}
