/*
 * author Xiaobin Wang
 **/
package edu.lpai.ldawapper;

public class LDAWapper {


	public native static void JNI_Train(String dir, String alpha, String beta, String ntopics, String niters, String savestep, String twords, String input_file);

	/*Train a lda model from dir+dfile, and same the model to dir, alpha\beta\topics\iter_num\save_step\top_words are model parameters. see: gibbslda.sourceforge.net
	 * */	
	public static void Train(String dir, double alpha, double beta, int topics, int iter_num, int save_step, int top_words, String input_file) {
		JNI_Train(dir, String.valueOf(alpha), String.valueOf(beta), String.valueOf(topics), String.valueOf(iter_num), String.valueOf(save_step), String.valueOf(top_words), input_file);
	}
	
	public native static void JNI_Inference(String dir, String model_name, String niters, String twords, String dfile);
	
	/* Inference the dir+dfile from model dir+model_name
	 * */
	public static void Inference(String dir, String model_name, int iter_num, int top_words, String file_path) {
		JNI_Inference(dir, model_name, String.valueOf(iter_num), String.valueOf(top_words), file_path);
	}
	
	static {
		System.loadLibrary("lda");
	}

	public static void main(String[] args) {
		System.out.println(System.getProperty("java.library.path"));
		System.loadLibrary("lda");
		//Train(".","testModel",2,4,2,"input");
		Inference(".", "model-final", 2, 2, "input");

	}	
}
