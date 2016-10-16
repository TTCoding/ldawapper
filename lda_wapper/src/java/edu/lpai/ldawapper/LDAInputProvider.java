package edu.lpai.ldawapper;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;

import IOHelp.SimpleIO;
import IOHelp.SimpleReader;
import NLPHelp.CoreNLPHelp;

public class LDAInputProvider {

	public static void main(String[] args) throws IOException, ReflectiveOperationException
	{
		String docDir = args[0],
				resultFp = args[1],
				docListFile = args[2];
				LDAInputPrepare(docDir,resultFp,docListFile);
	}
	
	/**Prepare the input file for gibbslda +  + 
	 * @throws IOException
	 * @throws ReflectiveOperationException
	 */
	static void LDAInputPrepare(String input_dir, String lda_input_file, String doc_id_map) throws IOException, ReflectiveOperationException
	{
		PrintStream lda_input_writer  =  new PrintStream(lda_input_file);
		List<String> docs  =  SimpleIO.FileList(input_dir, false);
		PrintStream doc_id_map_writer  =  new PrintStream(doc_id_map);
		lda_input_writer.print(docs.size() + "\n");
		int i = 0;
		for(String doc:docs)
		{
			String text = null;
			text = SimpleReader.ReadWithoutTag(doc);
			
			List<String> words = CoreNLPHelp.Lemmatization(text, true);
			StringBuilder out_line = new StringBuilder();
			for(String w:words)
				if(w.length() > 0)
					out_line.append(w + " ");
			if(out_line.length() == 0)
				continue;
			lda_input_writer.print(out_line.toString());
			lda_input_writer.print("\n");
			doc_id_map_writer.print(doc.substring(doc.lastIndexOf(File.separator) + 1) + "\t" + (i++) + "\n");
			SimpleIO.P("\rProcessed:" + i);
		}
		lda_input_writer.close();
		doc_id_map_writer.close();
	}
}
