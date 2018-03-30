import scrapy

class ArtistsNameSpider(scrapy.Spider):
    name = "artistname"

    def start_requests(self):
        urls = [
            'https://www.mutualart.com/ArtistsIndex/Category/19th-Century/303780681423B722',
            'https://www.mutualart.com/ArtistsIndex/Category/Impressionist---Modern/9A93F67AD02D7E4B',
            'https://www.mutualart.com/ArtistsIndex/Category/Old-Masters/35227B8B5BB6E569',
            'https://www.mutualart.com/ArtistsIndex/Category/Asian-Modern---Contemporary/F12F8284994400BD',
            'https://www.mutualart.com/ArtistsIndex/Category/Postwar---Contemporary/054412460E1796B5',
        ]
        for url in urls:
            yield scrapy.Request(url=url, callback=self.parse)

    def parse(self, response):
        for box in response.css('div.item-content'):
            link = box.css('h6.name a::attr(href)').extract_first()
            yield response.follow(link, self.parse_artist)

        next_page = response.css('li.next a::attr(href)').extract_first()
        if next_page is not None:
            yield response.follow(next_page, callback=self.parse)

    def parse_artist(self, response):
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
        art_title = response.css('div.text-block::text').extract_first().strip()

        yield {
            'name' : str(name),
            'nationality' : nationality,
            'years' : years,
            'art_title' : str(art_title),
            'art_link' : art_link,
        }
