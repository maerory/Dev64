import scrapy

class ArtistBioSpider(scrapy.Spider):
    name = "artistbio"

    def __init__(self, category=None, *urlargs):
        super(ArtistBioSpider, self).__init__(*urlargs)
        self.start_urls = ['http://www.mutualart.com%s' % category]

    def parse(self, response):
        name = (response.css('h1.name::text').extract_first()).strip()
        bio = response.css('p.desc').extract_first()

        if bio is not None:
            bio = bio.split('\r\n')
            nationality = bio[1].strip()
            if len(bio) > 2:
                years = bio[-2].strip()
            else:
                years = None
        else:
            nationality = years = None

        art_link = response.css('div.img-block img::attr(src)').extract_first()
        art_title = response.css('div.text-block::text').extract_first()

        yield {
            'name' : name,
            'nationality' : nationality,
            'years' : years,
            'art_title' : art_title,
            'art_link' : art_link,
        }
