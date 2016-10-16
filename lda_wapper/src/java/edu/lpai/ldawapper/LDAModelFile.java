package edu.lpai.ldawapper;

import gnu.trove.list.TDoubleList;
import gnu.trove.list.array.TDoubleArrayList;
import gnu.trove.map.TIntObjectMap;
import gnu.trove.map.TObjectIntMap;
import gnu.trove.map.hash.TIntObjectHashMap;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class LDAModelFile {
	
	public TIntObjectMap<TDoubleList> theta;
	public TIntObjectMap<TDoubleList> phi;
	public TObjectIntMap<String> doc_id_map;
	public TObjectIntMap<String> word_id_map;
	
	private final String model_dir;
	private final String model_name;
	private final String doc_id_map_path;

	public LDAModelFile(String _model_dir, String _model_name, String _doc_id_map_path) throws IOException {
		model_dir = _model_dir;
		model_name = _model_name;
		doc_id_map_path = _doc_id_map_path;
		theta = ReadDistributionFile(model_dir + File.separator + model_name + ".theta");
		phi = ReadDistributionFile(model_dir + File.separator + model_name + ".phi");
	}
	
	private static TIntObjectMap<TDoubleList> ReadDistributionFile(String File_path) throws IOException {
		TIntObjectMap<TDoubleList> retval = new TIntObjectHashMap<TDoubleList>();
		BufferedReader br = new BufferedReader(new FileReader(File_path));
		String line = null;
		int lineNum = 0;
		while((line = br.readLine())!=null)
		{
			String[] probStrs = line.split(" ");
			TDoubleList probs = new TDoubleArrayList(probStrs.length);
			for(String p:probStrs)
				probs.add(Double.parseDouble(p));
			
			retval.put(lineNum++,probs);
		}
		br.close();
		
		return retval;
	}

}
