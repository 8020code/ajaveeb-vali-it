package ee.bcs.koolitus.bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ee.bcs.koolitus.service.TagService;

public class Tag {

	private int blogId;
	private String tagsFromPost;
	private Map<Integer, String[]> testMap;

	public Tag() {
		super();
	}

	public Tag(Map<Integer, String> testMap) {
		super();
		this.testMap = splitTags();
	}

	public Tag(int blogId, String tagsFromPost) {
		super();
		this.blogId = blogId;
		this.tagsFromPost = tagsFromPost;
	}

	public int getBlogId() {
		return blogId;
	}

	public void setBlogId(int blogId) {
		this.blogId = blogId;
	}

	public String getTagsFromPost() {
		return tagsFromPost;
	}

	public void setTagsFromPost(String tagsFromPost) {
		this.tagsFromPost = tagsFromPost;
	}

	public static Map<Integer, String[]> splitTags() {

		TagService service = new TagService();
		List<Tag> listResult = service.getAllTags();// gives return of
													// getAllTags blogId and
													// tags_from_post

		List<Tag> lastEntry = new ArrayList<>();
		lastEntry.add(listResult.get(listResult.size() - 1));// getting the last
																// element in
																// the list

		// listBuffer = listBuffer[listBuffer.size()-1];

		Map<Integer, String[]> mapObj = new HashMap<>();
		Integer blogIdKeys;

		for (Tag list : lastEntry) {// does not allow output to web when empty
									// tags filed are left
			String bufferObj = list.toString();
			blogIdKeys = Integer.parseInt((bufferObj.split("#"))[0]);
			if ((bufferObj.split("#"))[1] != "") {
				String bufferObj1 = (bufferObj.split("#"))[1];// error comes
																// somewhere
																// here due to
																// no tags in
																// list to split
				String[] splittedArray = bufferObj1.split(",");
				mapObj.put(blogIdKeys, splittedArray);
			} else {
				String[] splittedArray = { "" };
				mapObj.put(blogIdKeys, splittedArray);
			}
		}

		for (Integer key : mapObj.keySet()) {
			System.out.println(key + " " + Arrays.deepToString(mapObj.get(key)));
		}
		return mapObj;

	}

	@Override
	public String toString() {
		return blogId + "#" + tagsFromPost;

	}

	//
	public Map<Integer, String[]> getTestMap() {
		return testMap;
	}

	public void setTestMap(Map<Integer, String[]> testMap) {
		this.testMap = testMap;
	}


}
