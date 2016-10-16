#include "edu_lpai_ldawapper_LDAWapper.h"
#include "model.h"
#include <string.h>
#include<iostream>
inline void GetCharsFromEnv(JNIEnv *env, jstring string, char* out) {
	const char *str = env->GetStringUTFChars(string, 0);
	strcpy(out, str);
	env->ReleaseStringUTFChars(string, str);
}

JNIEXPORT void JNICALL Java_edu_lpai_ldawapper_LDAWapper_JNI_1Train
  (JNIEnv *env, jclass object, jstring dir, jstring alpha, jstring beta, jstring niters, jstring savestep, jstring twords, jstring input_file) {	  
	char dir_cs[128], 
		 alpha_cs[32],
		 beta_cs[32],
		 niters_cs[16],
		 savestep_cs[16],
		 twords_cs[16],
		 input_file_cs[128];
	GetCharsFromEnv(env, dir, dir_cs);
	GetCharsFromEnv(env, alpha, alpha_cs);
	GetCharsFromEnv(env, beta, beta_cs);
	GetCharsFromEnv(env, niters, niters_cs);
	GetCharsFromEnv(env, savestep, savestep_cs);
	GetCharsFromEnv(env, twords, twords_cs);
	GetCharsFromEnv(env, input_file, input_file_cs);
	char* argv[15];
	argv[0] = "-est";
	argv[1] = "-dir";
	argv[2] = dir_cs;
	argv[3] = "-alpha";
	argv[4] = alpha_cs;
	argv[5] = "-beta";
	argv[6] = beta_cs;
	argv[7] = "-niters";
	argv[8] = niters_cs;
	argv[9] = "-savestep";
	argv[10] = savestep_cs;
	argv[11] = "-twords";
	argv[12] = twords_cs;
	argv[13] = "-dfile";
	argv[14] = input_file_cs;

	model lda;
	lda.init(15, argv);
	lda.estimate();
  }

/*
 * Class:     edu_lpai_ldawapper_LDAWapper
 * Method:    JNI_Inference
 * Signature: (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
 */
JNIEXPORT void JNICALL Java_edu_lpai_ldawapper_LDAWapper_JNI_1Inference
  (JNIEnv *env, jclass object, jstring dir, jstring model_name, jstring niters, jstring twords, jstring file_path) {
	char dir_cs[128], 
		 model_name_cs[128],
		 niters_cs[16],
		 twords_cs[16],
		 file_path_cs[128];
	GetCharsFromEnv(env, dir, dir_cs);
	GetCharsFromEnv(env, model_name, model_name_cs);
	GetCharsFromEnv(env, niters, niters_cs);
	GetCharsFromEnv(env, twords, twords_cs);
	GetCharsFromEnv(env, file_path, file_path_cs);
	std::cout << file_path << std::endl;
	std::cout << file_path_cs << std::endl;	
	char* argv[11];
	argv[0] = "-inf";
	argv[1] = "-dir";
	argv[2] = dir_cs;
	argv[3] = "-model";
	argv[4] = model_name_cs;
	argv[5] = "-niters";
	argv[6] = niters_cs;
	argv[7] = "-twords";
	argv[8] = twords_cs;
	argv[9] = "-dfile";
	argv[10] = file_path_cs;


	model lda;
	lda.init(11, argv);
	lda.inference();
  }

