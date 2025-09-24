package fi.csc.data.eosc.model;

import fi.csc.data.eosc.EOSCEntity;

import java.util.ArrayList;
import java.util.List;

import static fi.csc.data.eosc.ApplicationLifecycle.*;

public class EOSCPalvelu {
    //@Column(name = "avain", nullable = false, length = 64)
    //@Id
    public String avain;
    //@JoinColumn(name = "customer_segment", referencedColumnName = "id")
    public List<String> customerSegment;
    public String description_en;
    public String description_fi;
    //@Column(name = "end_user_groups")
    public List<String>  endUserGroups;
    public String end_user_guidance_en;
    public String end_user_guidance_fi;
    public String how_to_obtain_the_service_en;
    public String how_to_obtain_the_service_fi;
    public String interoperable_services;
    public String interoperable_services_urns;
    public String interoperable_services_websites;
    public String link_to_service_en;
    public String link_to_service_fi;
    public String link_to_sla_en;
    public String link_to_sla_fi;
    public String link_to_training_material_en;
    public String link_to_training_material_fi;
    public String link_to_user_guide_en;
    public String link_to_user_guide_fi;
    public String name_en;
    public String name_fi;
    public String persistent_identifier;
    public String privacy_policy_en;
    public String privacy_policy_fi;
    public String protection_level_max_en;
    public String protection_level_max_fi;
    public String protection_level_min_en;
    public String protection_level_min_fi;
    public List<String> purpose_of_the_service_en;
    public String purpose_of_the_service_fi;
    public String abbreviation;
    public String support_email_address;
    public String tagline_en;
    public String tagline_fi;
    public String technical_requirements_en;
    public String technical_requirements_fi;
    public String terms_of_use_en;
    public String terms_of_use_fi;
    public String topics_for_website_en;
    public String topics_for_website_fi;
    public String urn;
    public String website;
    public String determiner_en;
    public String determiner_fi;
    public String link_to_user_support_contact_form;
    public String logo;
    public String tou_specific_en;
    public String tou_specific_fi;
    public String tou_info_en;
    public String tou_info_fi;
    public String pricingpolicy_en;
    public String pricingpolicy_fi;
    public String tou_title_en;
    public String tou_title_fi;
    public String tou_specific_title_en;
    public String tou_specific_title_fi;
    public String service_owner;
    public String service_provider;
    public String detaileddescription_en;
    public String detaileddescription_fi;
    public String toms_en;
    public String toms_fi;
    public String geographicalAvailabilities;
    public String languageAvailabilities;
    public String securityContactEmail;
    public int trl;
    public AccessTypes accessTypes;
    public EOSCNodes nodeId;

    /**
     * Constructor from EOSCEntity
     *
     * @param e EOSCEntity from database
     */
    public EOSCPalvelu(EOSCEntity e) {
        this.avain = e.avain;
        this.customerSegment = cs(e.customerSegment);
        this.description_en = e.description_en;
        this.description_fi = e.description_fi;
        this.endUserGroups = show(e.endUserGroups);
        this.end_user_guidance_en = e.end_user_guidance_en;
        this.end_user_guidance_fi = e.end_user_guidance_fi;
        this.how_to_obtain_the_service_en = e.how_to_obtain_the_service_en;
        this.how_to_obtain_the_service_fi = e.how_to_obtain_the_service_fi;
        this.interoperable_services = e.interoperable_services;
        this.interoperable_services_urns = e.interoperable_services_urns;
        this.interoperable_services_websites = e.interoperable_services_websites;
        this.link_to_service_en = e.link_to_service_en;
        this.link_to_service_fi = e.link_to_service_fi;
        this.link_to_sla_en = e.link_to_sla_en;
        this.link_to_sla_fi = e.link_to_sla_fi;
        this.link_to_training_material_en = e.link_to_training_material_en;
        this.link_to_training_material_fi = e.link_to_training_material_fi;
        this.link_to_user_guide_en = e.link_to_user_guide_en;
        this.link_to_user_guide_fi = e.link_to_user_guide_fi;
        this.name_en = e.name_en;
        this.name_fi = e.name_fi;
        this.persistent_identifier = e.persistent_identifier;
        this.privacy_policy_en = e.privacy_policy_en;
        this.privacy_policy_fi = e.privacy_policy_fi;
        this.protection_level_max_en = e.protection_level_max_en;
        this.protection_level_max_fi = e.protection_level_max_fi;
        this.protection_level_min_en = e.protection_level_min_en;
        this.protection_level_min_fi = e.protection_level_min_fi;
        this.purpose_of_the_service_en = purpose(e.purpose_of_the_service);
        this.purpose_of_the_service_fi = e.purpose_of_the_service_fi;
        this.abbreviation = e.abbreviation;
        this.support_email_address = e.support_email_address;
        this.tagline_en = e.tagline_en;
        this.tagline_fi = e.tagline_fi;
        this.technical_requirements_en = e.technical_requirements_en;
        this.technical_requirements_fi = e.technical_requirements_fi;
        this.terms_of_use_en = e.terms_of_use_en;
        this.terms_of_use_fi = e.terms_of_use_fi;
        this.topics_for_website_en = e.topics_for_website_en;
        this.topics_for_website_fi = e.topics_for_website_fi;
        this.urn = e.urn;
        this.website = e.website;
        this.determiner_en = e.determiner_en;
        this.determiner_fi = e.determiner_fi;
        this.link_to_user_support_contact_form = e.link_to_user_support_contact_form;
        this.logo = e.logo;
        this.tou_specific_en = e.tou_specific_en;
        this.tou_specific_fi = e.tou_specific_fi;
        this.tou_info_en = e.tou_info_en;
        this.tou_info_fi = e.tou_info_fi;
        this.pricingpolicy_en = e.pricingpolicy_en;
        this.pricingpolicy_fi = e.pricingpolicy_fi;
        this.tou_title_en = e.tou_title_en;
        this.tou_title_fi = e.tou_title_fi;
        this.tou_specific_title_en = e.tou_specific_title_en;
        this.tou_specific_title_fi = e.tou_specific_title_fi;
        this.service_owner = e.service_owner;
        this.service_provider = e.service_provider;
        this.detaileddescription_en = e.detaileddescription_en;
        this.detaileddescription_fi = e.detaileddescription_fi;
        this.toms_en = e.toms_en;
        this.toms_fi = e.toms_fi;
        this.geographicalAvailabilities = e.geographicalAvailabilities;
        this.languageAvailabilities = e.languageAvailabilities;
        this.securityContactEmail = e.securityContactEmail;
        this.trl = e.trl;
        this.accessTypes = e.accessTypes;
        this.nodeId = e.nodeId;
    }

    /**
     * Use vocabulary to show End User Groups
     *
     * @param endUserGroups Integer Just a service id
     * @return List<String> endUserGroups in English
     */
    private List<String> show(Integer endUserGroups) {
        if (null == endUserGroups) {
            return null;
        }
        List<String> ls = new ArrayList<>();
        try {
            htbreug.get(endUserGroups).forEach(e -> ls.add(hteug.get(e).en));
        }  catch (java.lang.NullPointerException ex) {
            System.out.println("Nullpointer poikkeus endusergroupissaissä: " + endUserGroups);
            return null;
        }
        return ls;
    }

    /**
     * Use vocabulary to show  customer segments
     *
     * @param customerSegment Integer Just a service id
     * @return  List<String> customer segments in English
     */
    private List<String> cs(Integer customerSegment) {
        if (null == customerSegment) {
            return null;
        }
        List<String> ls = new ArrayList<>();
        try {
            htbrcg.get(customerSegment).forEach(cs -> ls.add(htcg.get(cs).en));
        } catch (java.lang.NullPointerException e) {
            System.out.println("Nullpointer poikkeus customersegmentissä: " + customerSegment);
            return null;
        }
        return ls;
    }

    /**
     * Use vocabulary to show   purposes
     *
     * @param p Integer Just a service id
     * @return List<String>  purposes in English
     */
    private List<String> purpose(Integer p) {
         if (null == p) {
             return null;
         }
        List<String> ls = new ArrayList<>();
         try {
             datapurpose.get(p).forEach(i -> ls.add(htpurpose.get(i).en));
         } catch (java.lang.NullPointerException e) {
             System.out.println("Nullpointer poikkeus purposessa: "+ p);
             return null;
         }
        return ls;
    }

}
