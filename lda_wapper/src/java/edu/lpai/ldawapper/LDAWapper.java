package edu.lpai.ldawapper;

public class LDAWapper {


	public native static void JNI_Train(String dir, String alpha, String beta, String niters, String savestep, String twords, String input_file);
	public static void Train(String dir, double alpha, double beta, int iter_num, int save_step, int top_words, String input_file) {
		JNI_Train(dir, String.valueOf(alpha), String.valueOf(beta), String.valueOf(iter_num), String.valueOf(save_step), String.valueOf(top_words), input_file);
	}
	
	public native static void JNI_Inference(String dir, String model_name, String niters, String twords, String dfile);
	public static void Inference(String dir, String model_name, int iter_num, int top_words, String file_path) {
		JNI_Inference(dir, model_name, String.valueOf(iter_num), String.valueOf(top_words), file_path);
	}
	
	public static void main(String[] args) {
		System.out.println(System.getProperty("java.library.path"));
		System.loadLibrary("lda");
		//Train(".","testModel",2,4,2,"input");
		Inference(".", "model-final", 2, 2, "input");

	}	
}
