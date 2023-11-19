#include "jni_HelloJni.h"
#include <stdio.h>
int main(){
	return 0;
} 
__declspec(dllexport) JNIEXPORT void JNICALL Java_jni_HelloJni_sayHello
(JNIEnv *env, jclass cl){
	printf("%s","Hello!");
}
