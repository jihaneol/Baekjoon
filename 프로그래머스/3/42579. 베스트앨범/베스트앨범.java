import java.util.*;

class Album{
    int idx, play;
    Album(int i, int p){
        idx = i;
        play = p;
    }
}
class BestAlbum{
    int play;
    List<Integer> values;
    BestAlbum(int p, List<Integer> v){
        play   = p;
        values = v;
    }
    public List<Integer> getValues(){
        return this.values;
    }
    
}
class Solution {
	public int[] solution(String[] genres, int[] plays) {
        
        Map<String, List<Album>> genreMap = new HashMap();
        List<Integer> answer = new ArrayList();
        
        for(int i=0; i<genres.length; i++){
            String genre = genres[i];
            int play = plays[i];
            
            if(!genreMap.containsKey(genre)){
                genreMap.put(genre, new ArrayList());
            }
            genreMap.get(genre).add(new Album(i, play));
                        
        }
        
        List<BestAlbum> bestAlbums = new ArrayList();
        
        genreMap.entrySet().forEach(entry ->{
            String genre = entry.getKey();
             List<Album> albums = genreMap.get(genre);
            
            if(albums.size()==1){
                bestAlbums.add(new BestAlbum(albums.get(0).play, Arrays.asList(albums.get(0).idx)));
            }
            else{
                 
            // 정렬
            albums.sort((a, b) -> {
                return a.play==b.play? Integer.compare(a.idx, b.idx) : Integer.compare(b.play, a.play);
            });
            bestAlbums.add(new BestAlbum(albums.stream().mapToInt(a1->a1.play).sum()
                                         , Arrays.asList(albums.get(0).idx, albums.get(1).idx)));
            }
           
        });
        
        // 베스트 앨범 정렬
        bestAlbums.sort((a,b) -> Integer.compare(b.play, a.play));
        
        for(BestAlbum ba : bestAlbums){
            answer.addAll(ba.getValues());
        }
        
		return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}