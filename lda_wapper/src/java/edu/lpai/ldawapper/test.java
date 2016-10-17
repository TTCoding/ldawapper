package edu.lpai.ldawapper;

import edu.lpai.ldawapper.LDAModelFile;
public class test {

	public static void main(String[] args) throws Exception {
		LDAInputProvider.LDAInputPrepare("testdata/raw_docs/", "testdata/lda_input_test", "testdata/doc_id");
		LDAWapper.Train("testdata/", 0.5, 0.1, 10, 10, 5, "lda_input_test");
		LDAWapper.Inference("testdata/", "model-final", 5, 5, "lda_input_test");
	}
}
