/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

/**
 *
 * @author mastermac
 */
public class FabricaArquivo {
    /**
     * <b>Autor: Professor Aecio</b> <p>
	 * Este código poderá ser usado para fins de estudo desde que o autor seja mencionado <p>
     * Adiciona uma string ao final do arquivo <p> 
     * <i> String arquivo = "c:\\temp\\teste.txt"; </i> <p>
     * <i> String string = "palavra"; </i>
     * @param string contendo a string a inserir
     * @param arquivo contendo o caminho e nome do arquivo
     * @return true se o dado foi inserido, false se nao inserido.
     * <p> <i> Data Ultima Alteracao 05/05/2012 </i>
     */
    public static boolean adicionarString(String string,String arquivo) {
        BufferedWriter objArq = null;
        try{
            boolean adicionar = true;
            objArq = new BufferedWriter(new FileWriter(arquivo,adicionar));
            objArq.write(string);
            objArq.close();
            objArq = null;
            return true;
        } catch(IOException e){
            System.out.println(e);
        } finally{
            if(objArq != null){
                try{
                    objArq.close();
                } catch(IOException e){
                    System.out.println(e);
                }
            }
        }
        return false;
    }
    /**
     * <b>Autor: Professor Aecio</b> <p>
	 * Este código poderá ser usado para fins de estudo desde que o autor seja mencionado <p>	 
     * Adiciona um vetor de caracteres no fim do arquivo <p>
     * <i> String arquivo = "c:\\temp\\teste.txt"; </i> <p>
     * <i> String string = "palavra"; </i>
     * @param vetorCaracteres vetor de (char[]) com os dados a adicionar
     * @param arquivo caminho e nome do arquivo a adicionar dados
     * @return true se o vetor foi inserido, false se nao inserido
     * <p> <i> Data Ultima Alteracao 05/05/2012 </i>
     */
    public static boolean adicionarVetorCaracteres(char[] vetorCaracteres,String arquivo){
        BufferedWriter objArq = null;
        try{
            boolean adicionar = true;
            objArq = new BufferedWriter(new FileWriter(arquivo,adicionar));
            objArq.write(vetorCaracteres);
            objArq.close();
            return true;
        } catch(IOException e){
            System.out.println(e);
        } finally{
            if(objArq != null){
                try{
                    objArq.close();
                } catch(IOException e){
                    System.out.println(e);
                }
            }
        }
        return false;

    }
    /**
     * <b>Autor: Professor Aecio</b> <p>
	 * Este código poderá ser usado para fins de estudo desde que o autor seja mencionado <p>	 
     * Adiciona um caracter no fim do arquivo <p>
     * <i> String arquivo = "c:\\temp\\teste.txt"; </i> <p>
     * <i> char caracter = 'a'; </i>
     * @param caracter a ser adicionado
     * @param arquivo caminho e nome do arquivo a adicionar dados
     * @return true se o char foi inserido, false se nao inserido
     * <p> <i> Data Ultima Alteracao 05/05/2012 </i>
     */

    public static boolean adicionarUmCaracter(char caracter,String arquivo){
        BufferedWriter objArq = null;
        boolean adicionar = true;
        try{
            objArq = new BufferedWriter(new FileWriter(arquivo,adicionar));
            objArq.write(caracter);
            objArq.close();
            return true;
        } catch(IOException e){
            System.out.println(e);
        } finally{
            if(objArq != null){
                try{
                    objArq.close();
                } catch(IOException e){
                    System.out.println(e);
                }
            }
        }

        return false;
    }
    /**
     * <b>Autor: Professor Aecio</b> <p>
	 * Este código poderá ser usado para fins de estudo desde que o autor seja mencionado <p>	 
     * Adiciona um caracter via codigo ASCII no fim do arquivo via codigo int ascii<p>
     * <i> int codASCII = 65; </i> <p>
     * <i> String arquivo = "c:\\temp\\teste.txt"; </i> 
     * @param codASCII a ser adicionado
     * @param arquivo caminho e nome do arquivo a adicionar dados
     * @return true se o char foi inserido, false se nao inserido
     * <p> <i> Data Ultima Alteracao 05/05/2012 </i>
     */
    public static boolean adicionarUmCaracterViaCodigoASCII(int codASCII,String arquivo){
        BufferedWriter objArq = null;
        try{
            boolean adicionar = true;
            objArq = new BufferedWriter(new FileWriter(arquivo,adicionar));
            objArq.write(codASCII);
            objArq.close();
            return true;
        } catch(IOException e){
            System.out.println(e);
        } finally{
            if(objArq != null){
                try{
                    objArq.close();
                } catch(IOException e){
                    System.out.println(e);
                }
            }
        }
        return false;
    }  
    /**
     * <b>Autor: Professor Aecio</b> <p>
	 * Este código poderá ser usado para fins de estudo desde que o autor seja mencionado <p>	 
     * Ler uma quantidade especifica de bytes do arquivo  para String<p>
     * <i> int numBytes = 5; </i> <p>
     * <i> String arquivo = "c:\\temp\\teste.txt"; </i> <p>
     * <i> int posicao = 10; </i>
     * @param numBytes a ler do arquivo
     * @param arquivo a ler a string
     * @param posicao do arquivo a ler os dados
     * @return string lida do arquivo
     * <p> <i> Data Ultima Alteracao 05/05/2012 </i>
     */
    public static String lerStringDoArquivo(int numBytes,String arquivo,int posicao){
        String dadoLido="";
        byte[] string = new byte[numBytes];
        RandomAccessFile objArq = null;
        try{
            objArq = new RandomAccessFile(arquivo,"r");
            objArq.seek(posicao);
            objArq.read(string);
            objArq.close();
            for(int i=0;i<string.length;i++)
                dadoLido = dadoLido + (char)string[i];
            return dadoLido;
        }catch(IOException e){
            System.out.println(e);
        } finally{
            if(objArq != null){
                try{
                    objArq.close();
                } catch(IOException e){
                    System.out.println(e);
                }
            }
        }
        return null;
    }
    /**
     * <b>Autor: Professor Aecio</b> <p>
	 * Este código poderá ser usado para fins de estudo desde que o autor seja mencionado <p>	 
     * Ler uma quantidade especifica de bytes do arquivo para char[] <p>
     * <i> int numBytes = 5; </i> <p>
     * <i> String arquivo = "c:\\temp\\teste.txt"; </i> <p>
     * <i> int posicao = 10; </i>
     * @param numBytes a serem lidos
     * @param arquivo e nome do arquivo a adicionar dados
     * @param posicao do arquivo a ler os dados
     * @return vetor de char[] com os dados lidos
     * <p> <i> Data Ultima Alteracao 05/05/2012 </i>
     */
    public static char[] lerVetorCaracteresDoArquivo(int numBytes,String arquivo,int posicao){
        byte[] string = new byte[numBytes];
        char[] dados = new char[numBytes];
        RandomAccessFile objArq=null;
        try{
            objArq = new RandomAccessFile(arquivo,"r");
            objArq.seek(posicao);
            objArq.read(string);
            objArq.close();
            for(int i=0;i<string.length;i++)
                dados[i] =  (char)string[i];
            return dados;
        }catch(IOException e){
            System.out.println(e);
        } finally{
            if(objArq != null){
                try{
                    objArq.close();
                } catch(IOException e){
                    System.out.println(e);
                }
            }
        }
        return null;
    }   
    /**
     * <b>Autor: Professor Aecio</b> <p>
	 * Este código poderá ser usado para fins de estudo desde que o autor seja mencionado <p>	 
     * Sobrescrever uma quantidade especifica de bytes do arquivo <p>
     * <i> String string = "palavra"; </i> <p>
     * <i> int numBytes = 5; </i> <p>
     * <i> String arquivo = "c:\\temp\\teste.txt"; </i> <p>
     * <i> int posicao = 10; </i>
     * @param string com palavra a sobrescrever
     * @param numBytes a serem lidos
     * @param arquivo e nome do arquivo a adicionar dados
     * @param posicao do arquivo a ler os dados
     * @return true se a string foi sobrescrita, false se nao
     * <p> <i> Data Ultima Alteracao 05/05/2012 </i>
     */
    public static boolean sobrescreverString(String string,int numBytes,String arquivo,int posicao){
        RandomAccessFile objArq = null;
        try{
            objArq = new RandomAccessFile(arquivo,"rw");
            byte[] str = new byte[numBytes];
            for(int i=0;i<numBytes;i++)
                str[i] = (byte) string.charAt(i);
            objArq.seek(posicao);
            objArq.write(str);
            objArq.close();
            return true;
        }catch(IOException e){
            System.out.println(e);
        } finally{
            if(objArq != null){
                try{
                    objArq.close();
                } catch(IOException e){
                    System.out.println(e);
                }
            }
        }
        return false;
    }
    /**
     * <b>Autor: Professor Aecio</b> <p>
	 * Este código poderá ser usado para fins de estudo desde que o autor seja mencionado <p>	 
     * Sobrescrever uma quantidade especifica de bytes do arquivo
     * <i> String string = "palavra"; </i> <p>
     * <i> String arquivo = "c:\\temp\\teste.txt"; </i> <p>
     * <i> int posicao = 10; </i>
     * @param string com palavra a sobrescrever
     * @param arquivo e nome do arquivo a adicionar dados
     * @param posicao do arquivo a sobrescrever os dados
     * @return true se a string foi sobrescrita, false se nao
     * <p> <i> Data Ultima Alteracao 05/05/2012 </i>
     */
    public static boolean sobrescreverString(String string,String arquivo,int posicao){
        RandomAccessFile objArq = null;
        try{
            objArq = new RandomAccessFile(arquivo,"rw");
            byte[] str = new byte[string.length()];
            for(int i=0;i<string.length();i++)
                str[i] = (byte) string.charAt(i);
            objArq.seek(posicao);
            objArq.write(str);
            objArq.close();
            return true;
        }catch(IOException e){
            System.out.println(e);
        } finally{
            if(objArq != null){
                try{
                    objArq.close();
                } catch(IOException e){
                    System.out.println(e);
                }
            }
        }
        return false;
    } 
    /**
     * <b>Autor: Professor Aecio</b> <p>
	 * Este código poderá ser usado para fins de estudo desde que o autor seja mencionado <p>	 
     * Testa se um arquivo existe ou não <p>
     * <i> String arquivo = "c:\\temp\\teste.txt"; </i>
     * @param caminho e nome do arquivo a adicionar dados
     * @return boolean true se o arquivo existe e false caso contrario
     * <p> <i> Data Ultima Alteracao 05/05/2012 </i>
     */      
    public static boolean testaArquivoExiste(String arquivo){
        boolean arquivoExiste = (new File(arquivo)).exists();
        return arquivoExiste;
    }
    /**
     * <b>Autor: Professor Aecio</b> <p>
	 * Este código poderá ser usado para fins de estudo desde que o autor seja mencionado <p>	 
     * Apaga um arquivo <p>
     * <i> String arquivo = "c:\\temp\\teste.txt"; </i>
     * @param caminho e nome do arquivo a apagar
     * @return boolean true se apagou, e false caso contrario
     * <p> <i> Data Ultima Alteracao 05/05/2012 </i>
     */      
    public static boolean apagaArquivo(String nomeArquivo){
        File arquivo = new File(nomeArquivo);
        boolean arquivoApagado;
        arquivoApagado = arquivo.delete();
        return arquivoApagado;
    }
    /**
     * <b>Autor: Professor Aecio</b> <p>
	 * Este código poderá ser usado para fins de estudo desde que o autor seja mencionado <p>	 
     * Retorna o tamanho em bytes de um arquivo <p>
     * <i> String arquivo = "c:\\temp\\teste.txt"; </i>
     * @param caminho e nome do arquivo retornar o tamanho
     * @return long com o numero de bytes do arquivo
     * <p> <i> Data Ultima Alteracao 05/05/2012 </i>
     */    
    public static Long tamanhoArquivo(String arquivo){
        RandomAccessFile objArq=null;
        Long tamanho;
        try{
            objArq = new RandomAccessFile(arquivo,"r");
            tamanho = objArq.length();
            return tamanho;            
        }catch(IOException e){
            System.out.println(e);
        } finally{
            if(objArq != null){
                try{
                    objArq.close();
                } catch(IOException e){
                    System.out.println(e);
                }
            }
        }
        return null;
    }
    /**
     * <b>Autor: Professor Aecio</b> <p>
	 * Este código poderá ser usado para fins de estudo desde que o autor seja mencionado <p>	 
     * Retorna o posição atual em bytes de um arquivo <p>
     * <i> String arquivo = "c:\\temp\\teste.txt"; </i>
     * @param caminho e nome do arquivo retornar a posicao atual
     * @return Long com o numero de bytes da posicao atual do arquivo
     * <p> <i> Data Ultima Alteracao 05/05/2012 </i>
     */
    public static Long posicaoAtualArquivo(String arquivo){
        RandomAccessFile objArq = null;
        Long pos = null;
        try{
            objArq = new RandomAccessFile(arquivo,"r");
            pos =objArq.getFilePointer();
            objArq.close();
            return pos;
        }catch(IOException e){
            System.out.println(e);
        } finally{
            if(objArq != null){
                try{
                    objArq.close();
                } catch(IOException e){
                    System.out.println(e);
                }
            }
        }
        return null;
    }
    /**
     * <b>Autor: Professor Aecio</b> <p>
	 * Este código poderá ser usado para fins de estudo desde que o autor seja mencionado <p>	 
     * Ler uma quantidade especifica de bytes do arquivo por uma linha inteira <p>
     * <i> String arquivo = "c:\\temp\\teste.txt"; </i> <p>
     * <i> long posicao para comecar a ler os dados
     * @param arquivo caminho e nome do arquivo retornar a posicao atual
     * @param posicao para comecar a ler os dados
     * @return string da linha lida
     * <p> <i> Data Ultima Alteracao 05/05/2012 </i>
     */
    public static String lerLinhaDoArquivo(String arquivo,long posicao){
        String dadoLido="";
        RandomAccessFile objArq=null;
        try{
            objArq = new RandomAccessFile(arquivo,"r");
            objArq.seek(posicao);
            dadoLido = objArq.readLine();
            objArq.close();
            return dadoLido;
        }catch(IOException e){
            System.out.println(e);
        } finally{
            if(objArq != null){
                try{
                    objArq.close();
                } catch(IOException e){
                    System.out.println(e);
                }
            }
        }
        return null;
    }  
    /**
     * <b>Autor: Professor Aecio</b> <p>
	 * Este código poderá ser usado para fins de estudo desde que o autor seja mencionado <p>	 
     * Apaga todos os arquivos de um diretorio <p>
     * <i> String arquivo = "c:\\temp\\teste.txt"; </i> <p>
     * @param diretorio File caminho e nome do diretorio a apagar
     * @return boolean se apagou ou nao
     * <p> <i> Data Ultima Alteracao 13/05/2012 </i>
     */    
    public static boolean apagarDiretorio(File diretorio) {  
        if (diretorio.isDirectory()) {  
            String[] children = diretorio.list();  
            for (int i=0; i<children.length; i++) {  
                boolean success = apagarDiretorio(new File(diretorio, children[i] ));  
                if (!success) {  
                    return false;  
                }  
            }  
        }  
        // The directory is now empty so delete it  
        return diretorio.delete();  
    }  
    /**
     * <b>Autor: Professor Aecio</b> <p>
	 * Este código poderá ser usado para fins de estudo desde que o autor seja mencionado <p>	 
     * Apaga todos os arquivos de um diretorio <p>
     * <i> String arquivo = "c:\\temp\\teste.txt"; </i> <p>
     * @param str String caminho e nome do diretorio a apagar
     * @return boolean se apagou ou nao
     * <p> <i> Data Ultima Alteracao 13/05/2012 </i>
     */    
    public static boolean apagarDiretorio(String str){
        File diretorio = new File(str);
        return apagarDiretorio(diretorio);
    }
    /**
     * <b>Autor: Professor Aecio</b> <p>
	 * Este código poderá ser usado para fins de estudo desde que o autor seja mencionado <p>	 
     * Cria um diretorio <p>
     * <i> String arquivo = "c:\\temp\\teste.txt"; </i> <p>
     * @param str String caminho e nome do diretorio a criar
     * @return boolean se criou ou nao
     * <p> <i> Data Ultima Alteracao 13/05/2012 </i>
     */    
    public static boolean criarDiretorio(String str){
        File dir = new File(str);
        return dir.mkdirs();
    }   
    /**
     * <b>Autor: Professor Aecio</b> <p>
	 * Este código poderá ser usado para fins de estudo desde que o autor seja mencionado <p>	 
     * Clona um arquivo <p>
     * <i> String arquivo = "c:\\temp\\teste.txt"; </i> <p>
     * @param input String caminho e nome do arquivo origem
     * @param output String caminho e nome do arquivo destino
     * @return boolean se criou ou nao
     * <p> <i> Data Ultima Alteracao 13/05/2012 </i>
     */    
    public static boolean clonaArquivoByte2Byte(String input,String output){
        long tamanho,pos;
        boolean semErro;
        String c;
        tamanho = tamanhoArquivo(input);
        pos=(long)0;
        while(pos<tamanho){
            c = new String();
            c = lerStringDoArquivo(1, input, (int)pos);
            semErro = adicionarString(c, output);
            if(semErro == false)
                return semErro;
            pos++;
        }
        return true;
    }
    /**
     * <b>Autor: Professor Aecio</b> <p>
	 * Este código poderá ser usado para fins de estudo desde que o autor seja mencionado <p>	 
     * Clona um arquivo <p>
     * <i> String arquivo = "c:\\temp\\teste.txt"; </i> <p>
     * @param input String caminho e nome do arquivo origem
     * @param output String caminho e nome do arquivo destino
     * @return boolean se criou ou nao
     * <p> <i> Data Ultima Alteracao 13/05/2012 </i>
     */    
    public static boolean clonaArquivo(String input,String output){
        //streams  
        FileInputStream origem;  
        FileOutputStream destino;  
        //canais  
        FileChannel fcOrigem;  
        FileChannel fcDestino; 
        
        try{
            origem = new FileInputStream(input );  
            destino = new FileOutputStream(output );            
            fcOrigem = origem.getChannel();  
            fcDestino = destino.getChannel(); 
            fcOrigem.transferTo(0, fcOrigem.size(), fcDestino);  
            origem.close();  
            destino.close();
        }catch(IOException e){
            return false;
        }
        return true;
    }    
}
