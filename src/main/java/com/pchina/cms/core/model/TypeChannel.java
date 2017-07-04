package com.pchina.cms.core.model;

public class TypeChannel {
    private Integer id;

    private Integer tid;

    private String topics;

    private Integer type;
    
    private String topletang;
   
    private String tophubii;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getTopics() {
        return topics;
    }

    public void setTopics(String topics) {
        this.topics = topics == null ? null : topics.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

	public String getTopletang() {
		return topletang;
	}

	public void setTopletang(String topletang) {
		this.topletang = topletang;
	}

	public String getTophubii() {
		return tophubii;
	}

	public void setTophubii(String tophubii) {
		this.tophubii = tophubii;
	}
    
    
}