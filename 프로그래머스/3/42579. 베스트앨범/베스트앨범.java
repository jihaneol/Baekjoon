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
        /**
        장르 별로 가장 많이 재생된 노래 2개씩 모은다.
        1만
        
        수록 기준
        1. 속한 노래 많이 재생된 장르를 먼저 수록
        2. 장르 내 많이 재생된 노래를 먼저 수록
        3. 장르 내에서는 고유 번호가 낮은 노래 
        
        고유 번호 = 장르 인덱스 번호
        
        장르 모음 - <장르, List<앨범>>
        앨범 - 고유 번호, 재생 횟수
        order by 재생횟수 , 고유번호 asc
        
        1. set으로 장르들 모아서
        2. map으로 장르에 앨범 삽입
        3. set 꺼내오면서 map의 앨범 정렬 하고 1,2개 횟수 꺼내서 max인 친구를 배스트 앨범 재생회수에, 그리고 나머지 고유번호는 list에
        4. 배스트 앨범 객체 (재생 횟수, 고유번호List) 만든 객체로 정렬해
        5. 정렬한 객체 꺼내면서 고유번호들 빼..
        **/
        Map<String, List<Album>> genreMap = new HashMap();
        Set<String> genreSet = new HashSet();
        List<Integer> answer = new ArrayList();
        
        for(int i=0; i<genres.length; i++){
            String genre = genres[i];
            int play = plays[i];
            
            genreSet.add(genre);
            if(!genreMap.containsKey(genre)){
                genreMap.put(genre, new ArrayList());
            }
            genreMap.get(genre).add(new Album(i, play));
                        
        }
        List<BestAlbum> bestAlbums = new ArrayList();
        
        for(String genre : genreSet){
            List<Album> albums = genreMap.get(genre);
            
            if(albums.size()==1){
                bestAlbums.add(new BestAlbum(albums.get(0).play, Arrays.asList(albums.get(0).idx)));
                continue;
            }
            
            // 정렬
            albums.sort((a, b) -> {
                return a.play==b.play? Integer.compare(a.idx, b.idx) : Integer.compare(b.play, a.play);
            });
            bestAlbums.add(new BestAlbum(albums.stream().mapToInt(a1->a1.play).sum()
                                         , Arrays.asList(albums.get(0).idx, albums.get(1).idx)));
            
        }
        
        // 베스트 앨범 정렬
        bestAlbums.sort((a,b) -> Integer.compare(b.play, a.play));
        
        for(BestAlbum ba : bestAlbums){
            answer.addAll(ba.getValues());
        }
        
		return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}