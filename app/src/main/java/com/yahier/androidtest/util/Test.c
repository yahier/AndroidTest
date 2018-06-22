#include "com_yahier_androidtest_util_JniTest.h"
#include <studio.h>

JNIEXPORT jstring JNICALL Java_com_yahier_androidtest_util_JniTest_get(JNIEnv *env,jobject thiz)[
  printf("invoke get from C\n");
  return (*env) ->NewStringUTF(env,"Hello from NJI!");
  }

JNIEXPORT void JNICALL Java_com_yahier_androidtest_util_JniTest_set(JNIEnv *env,jobjecr thiz,jstring string){
 printf("invoke set from C\n");
 char* str = (char*)(*env)->GetStringUTFChars(env,string,NULL);
 printf("%s\n",str);
 (*env)->ReleaseStringUTFChars(env,string,str);
 }