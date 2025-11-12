# Add project-specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in /usr/local/android-sdk/tools/proguard/proguard-android.txt

# For example, to keep all classes in the org.example package:
# -keep class org.example.** { *; }

# Uncomment and adjust the next lines to keep your model classes if using reflection or serialization:
# -keep class com.aji.mazevelocity.model.** { *; }

# Rules to keep Kotlin data classes
-keep class kotlin.** { *; }

# Rules to avoid stripping out XML attributes in layouts
-keepclassmembers class * extends android.view.View {
    public <init>(android.content.Context, android.util.AttributeSet);
}

# You can add more rules for libraries or features you use!