package com.helloxin.common;

import lombok.Data;

@Data
public class BindGroup {
    private String subject;
    private String group;
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof BindGroup)) {
            return false;
        } else {
            BindGroup other = (BindGroup)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$subject = this.getSubject();
                Object other$subject = other.getSubject();
                if (this$subject == null) {
                    if (other$subject != null) {
                        return false;
                    }
                } else if (!this$subject.equals(other$subject)) {
                    return false;
                }

                Object this$group = this.getGroup();
                Object other$group = other.getGroup();
                if (this$group == null) {
                    if (other$group != null) {
                        return false;
                    }
                } else if (!this$group.equals(other$group)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof BindGroup;
    }

    @Override
    public int hashCode() {
        boolean PRIME = true;
        int result = 1;
        Object $subject = this.getSubject();
        result = result * 59 + ($subject == null ? 43 : $subject.hashCode());
        Object $group = this.getGroup();
        result = result * 59 + ($group == null ? 43 : $group.hashCode());
        return result;
    }
}
